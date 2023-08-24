package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.BacsUser;
import net.softsociety.bacs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// @Controller + @ResponseBody
@RestController
@Slf4j
@RequestMapping("member")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("getUserList")
    public ArrayList<BacsUser> getUserList() {
        return service.getUserList();
    }
}
