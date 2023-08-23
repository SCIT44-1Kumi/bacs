package net.softsociety.bacs.controller;

import net.softsociety.bacs.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController
{
    @Autowired
    MenuService service;

    @GetMapping("/menuForm")
    public String menuForm()
    {
        String menuForm = service.menuForm();
        return menuForm;
    }
}
