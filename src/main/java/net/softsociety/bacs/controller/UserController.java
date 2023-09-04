package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.vo.BacsUser;
import net.softsociety.bacs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// @Controller + @ResponseBody
@RestController
@Slf4j
@RequestMapping("member")
public class UserController {

    @Autowired
    UserService service;

    /**
     * 회원 목록 가져오기
     * @return list
     */
    // TODO: 회원가입
    @PostMapping("join")
    public String join(BacsUser user){
        log.debug("{}",user);
        service.join(user);
        return "redirect:/";
    }
    // TODO: 로그인 (JWT방식으로 공부 후 개발)

    // TODO: 회원탈퇴
    // TODO: 프로필 업데이트

}
