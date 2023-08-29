package net.softsociety.bacs.controller;


import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.BacsMenu;
import net.softsociety.bacs.domain.BacsMenuOption;

import net.softsociety.bacs.dto.InsertMenuDTO;
import net.softsociety.bacs.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("menu")
@Slf4j
public class MenuController
{
    @Autowired
    MenuService service;

    @PostMapping("create")
    public boolean createMenu(@RequestBody InsertMenuDTO data){
        log.debug("========dto======: {}", data);
        BacsMenu menu = data.getMenu();
        ArrayList<BacsMenuOption> options = data.getOptions();
        return service.createMenu(menu, options);
    }

}
