package net.softsociety.bacs.user.service;

import lombok.RequiredArgsConstructor;
import net.softsociety.bacs.user.dao.UserDAO;
import net.softsociety.bacs.domain.vo.BacsUser;
import net.softsociety.bacs.user.controller.dto.LoginRequestDto;
import net.softsociety.bacs.user.entity.BacsUserRepository;
import net.softsociety.bacs.user.exception.AuthenticationErrorCode;
import net.softsociety.bacs.user.redis.entity.UserRefreshToken;
import net.softsociety.bacs.user.redis.repository.RefreshTokenRepository;
import net.softsociety.bacs.user.service.data.TokenPair;
import net.softsociety.bacs.util.jwt.JwtProvider;
import net.softsociety.bacs.util.random.StringSecuredRandom;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public final class AuthenticationService
        implements LoginUseCase {

    // DAOs
    private final BacsUserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    // Utilities
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final StringSecuredRandom securedRandom;

    @Override
    public TokenPair login(String userId, String userPw) {
        // 회원 존재하는지 확인
        BacsUser user = userRepository
                .findByUserId(userId)
                .orElseThrow(AuthenticationErrorCode.ID_PW_MISMATCHED::defaultException);

        // 비밀번호 검증
        boolean matches = passwordEncoder.matches(
                userPw,
                user.getUserPw()
        );

        //
        if (!matches) {
            throw AuthenticationErrorCode.ID_PW_MISMATCHED.defaultException();
        }

        // 여기까지 왔으면 아이디/비밀번호 일치한다는 것

        // Generate refresh token
        String refreshToken = securedRandom.next(32);

        // TODO save refresh token
        UserRefreshToken userRefreshToken = UserRefreshToken.builder()
                .refreshToken(refreshToken)
                .userId(userId)
                .ttl(2_592_000L)
                .build();

        refreshTokenRepository.save(userRefreshToken);
        // ... refreshTokenRepository.findById(refreshToken);


        return TokenPair.builder()
                .accessToken(generateAccessToken(user))
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public String login(LoginRequestDto dto, HttpServletResponse response) {
        TokenPair tokenPair = login(dto.userId(), dto.userPw());

        // Cookie 생성하는 서비스 따로 두는 게.
        Cookie cookie = new Cookie("refresh_token", tokenPair.refreshToken());
        cookie.setMaxAge(2_592_000); // seconds
        cookie.setDomain(""); // localhost
        cookie.setPath("/");
        // cookie.setSecure(true); // <<< 배포 환경(HTTPS만 허용)
        cookie.setHttpOnly(true); // <<< 클라이언트단 스크립트에서 접근이 안 되게 막는 것.

        response.addCookie(cookie);

        return tokenPair.accessToken();
    }

    private String generateAccessToken(BacsUser user) {
        Map<String, String> claimsMap = new HashMap<>();

        // TODO 보통 우선순위
        // FIXME 높은 우선순위

        claimsMap.put("authority", user.getRolename().toString()); // FIXME formatting
        claimsMap.put("email", user.getEmail());

        // JWT: subject -> sub
        return jwtProvider.generate(user.getUserId(), claimsMap);
    }
}
