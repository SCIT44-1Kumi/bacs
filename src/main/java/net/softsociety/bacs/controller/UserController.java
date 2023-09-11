package net.softsociety.bacs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.dto.MemberLoginRequestDTO;
import net.softsociety.bacs.domain.dto.TokenInfo;
import net.softsociety.bacs.domain.vo.BacsUser;
import net.softsociety.bacs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// @Controller + @ResponseBody
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("member")
public class UserController {

    @Autowired
    UserService service;

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
    public TokenInfo login(@RequestBody MemberLoginRequestDTO memberLoginRequestDto) {
        String userId = memberLoginRequestDto.getUserId();
        String userPw = memberLoginRequestDto.getUserPw();
        log.debug("{}", memberLoginRequestDto);
        TokenInfo tokenInfo = service.login(userId, userPw);
        log.debug("{}", tokenInfo);
        return tokenInfo;
    }
    // TODO: 회원탈퇴
    // TODO: 프로필 업데이트

}
