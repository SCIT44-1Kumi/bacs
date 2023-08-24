package net.softsociety.bacs.controller;


import net.softsociety.bacs.domain.BacsMenu;
import net.softsociety.bacs.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("menu")
public class MenuController
{
    @Autowired
    MenuService service;

    @PostMapping("/menuForm")
    public String menuForm(BacsMenu menu) {
        String menuForm = service.menuForm();
        return menuForm;
    }

    @GetMapping("getMenuList")
    public ArrayList<BacsMenu> getMenuList(String store_id){
        return service.getMenuList(store_id);
    }
}
