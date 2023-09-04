package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.vo.BacsUser;
import net.softsociety.bacs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    @GetMapping("getUserList")
    public ArrayList<BacsUser> getUserList() {
        return service.getUserList();
    }

    // TODO: 회원가입
    // TODO: 로그인
    // TODO: 회원탈퇴
    // TODO: 프로필 업데이트

}
