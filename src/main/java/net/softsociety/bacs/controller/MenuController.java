package net.softsociety.bacs.controller;


import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.dto.menu.DeleteMenuDTO;
import net.softsociety.bacs.domain.dto.menu.DeleteMenuOptionDTO;
import net.softsociety.bacs.domain.vo.BacsMenu;
import net.softsociety.bacs.domain.vo.BacsMenuOption;
import net.softsociety.bacs.domain.vo.BacsMenu;
import net.softsociety.bacs.domain.vo.BacsMenuOption;

import net.softsociety.bacs.domain.dto.menu.InsertMenuDTO;
import net.softsociety.bacs.domain.dto.InsertMenuDTO;
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

    /**
     * 메뉴 삭제
     * 아이디와 메뉴 번호를 받아가서 메뉴 삭제
     * @param data
     */
    @PostMapping("deleteMenu")
    public int deleteMenu(@RequestBody DeleteMenuDTO data)
    {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        // TODO : 이미지 삭제 처리
        log.debug("DTO: {}", data);
        return service.deleteMenu(data);
    }

    /**
     * 메뉴 옵션 삭제
     * 옵션 번호와 메뉴 번호를 받아가서 메뉴 옵션 삭제
     * @param data
     */
    @PostMapping("deleteMenuOption")
    public int deleteMenuOption(@RequestBody DeleteMenuOptionDTO data)
    {
        log.debug("DTO: {}", data);
        return service.deleteMenuOption(data);
    }


    /**
     * 메뉴 수정
     * 아이디와 메뉴 번호를 받아가서 메뉴 수정
     * (VO의 내용이 다 필요해서 DTO안만듦)
     * @param data
     */
    @PostMapping("updateMenu")
    public int updateMenu(@RequestBody BacsMenu data)
    {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        // TODO : 이미지 경로 수정 처리
        log.debug("updateMenu: {}", data);
        return service.updateMenu(data);
    }

    /**
     * 메뉴 옵션 수정
     * 옵션 번호 메뉴 번호를 받아가서 메뉴 옵션 수정
     * (VO의 내용이 다 필요해서 DTO안만듦)
     * @param data
     */
    @PostMapping("updateMenuOption")
    public int updateMenuOption(@RequestBody BacsMenuOption data)
    {
        log.debug("updateMenuOption: {}", data);
        return service.updateMenuOption(data);
    }

}