package net.softsociety.bacs.controller;


import net.softsociety.bacs.domain.BacsMenu;
import net.softsociety.bacs.domain.BacsMenuOption;

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

    /**
     * 20230823 메뉴추가
     *
     * @param BacsMenu menu, BacsMenuOption menuOption
     * @return MenuInsert
     */
    @PostMapping("/menuForm") //메뉴추가에서 입력한 form 이름
    public BacsMenu menuInsert(BacsMenu menu, BacsMenuOption menuOption,
                               @AuthenticationPrincipal UserDetails user)
    {
        menu.storeId(user.getUsername());	    //매장명
        service.menuInsert(menu);               //메뉴추가

        int num = menu.getMenuNum();
        menuOption.menuNum(num);
        service.menuOptionInsert(menuOption);   //메뉴옵션추가
        return menu; //메뉴추가 화면으로 돌아가야함
    }

    @GetMapping("getMenuList")
    public ArrayList<BacsMenu> getMenuList(String store_id){
        return service.getMenuList(store_id);
    }
}
