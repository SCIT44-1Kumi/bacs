package net.softsociety.bacs.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.dto.TokenInfo;
import net.softsociety.bacs.domain.vo.BacsUser;
import net.softsociety.bacs.service.UserService;
import net.softsociety.bacs.user.controller.dto.LoginRequestDto;
import net.softsociety.bacs.user.controller.dto.LoginResponseDto;
import net.softsociety.bacs.user.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

// @Controller + @ResponseBody
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("member")
public class UserController {

    private final UserService service;
    private final AuthenticationService authenticationService;

    /**
주     * 회원 목록 가져오기 하면서 확인 필요
     * @return list
     */

    @PostMapping("join")
    public String join(BacsUser user){
        log.debug("{}",user);
        service.join(user);
        return "redirect:/";
    }
    // TODO: 로그인 (JWT방식으로 공부 후 개발)

    @PostMapping("login")
    public TokenInfo login(@RequestBody @Valid LoginRequestDto memberLoginRequestDto) {
        String userId = memberLoginRequestDto.userId();
        String userPw = memberLoginRequestDto.userPw();
        log.debug("{}", memberLoginRequestDto);
        TokenInfo tokenInfo = service.login(userId, userPw);
        log.debug("{}", tokenInfo);
        return tokenInfo;
    }
    // TODO: 회원탈퇴
    // TODO: 프로필 업데이트

    @PostMapping("temp-login")
    public LoginResponseDto loginEx(
            @RequestBody @Valid LoginRequestDto body,
            HttpServletResponse response
    ) {
        String accessToken = authenticationService.login(body, response);

        return LoginResponseDto.builder()
                .token(accessToken) // access token
                .requires2Fa(false)
                .build();
    }
}
