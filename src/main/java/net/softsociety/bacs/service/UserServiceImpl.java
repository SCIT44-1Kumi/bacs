package net.softsociety.bacs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.UserDAO;
import net.softsociety.bacs.domain.dto.SaleTodayDTO;
import net.softsociety.bacs.domain.dto.TokenInfo;

import net.softsociety.bacs.domain.vo.BacsUser;

import net.softsociety.bacs.user.exception.AuthenticationErrorCode;
import net.softsociety.bacs.user.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;


    @Override
    @Transactional
    public TokenInfo login(String userId, String userPw) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, userPw);

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // Optional<T> -> .orElseThrow(...) => 논널값 or 예외 => 이후 로직은 널이 아님을 보장.
//        BacsUser user = dao.getUser("")
//                .orElseThrow(AuthenticationErrorCode.ID_PW_MISMATCHED::defaultException);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = TokenInfo.builder()
                .grantType("")
                .accessToken("")
                .refreshToken("")
                .build();

        return tokenInfo;
    }


    @Override
    public int join(BacsUser user) {
        return dao.join(user);
    }

    @Override
    public int saleToday(SaleTodayDTO data){
        return dao.saleToday(data);
    }

    @Override
    public int salesWeek(SaleTodayDTO data){
        return dao.salesWeek(data);
    }
}
