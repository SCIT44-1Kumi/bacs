package net.softsociety.bacs.controller;

import net.softsociety.bacs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// @ResponseBody + @Controller
@RestController
public class ExampleController {

    @Autowired
    AdminService service;

    @GetMapping("/admin")
    public String admin() {
        String ex = service.getStoreInfo();
        return "";
    }
}
