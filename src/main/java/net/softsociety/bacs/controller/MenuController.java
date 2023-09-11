package net.softsociety.bacs.controller;


import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.dto.category.SelectCategoryDTO;
import net.softsociety.bacs.domain.dto.menu.DeleteMenuDTO;
import net.softsociety.bacs.domain.dto.menu.DeleteMenuOptionDTO;
import net.softsociety.bacs.domain.dto.menu.InsertMenuDTO;
import net.softsociety.bacs.domain.vo.BacsCategory;
import net.softsociety.bacs.domain.vo.BacsMenu;
import net.softsociety.bacs.domain.vo.BacsMenuOption;

import net.softsociety.bacs.domain.dto.menu.InsertMenuDTO;
import net.softsociety.bacs.service.CategoryService;
import net.softsociety.bacs.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;


@RestController
@RequestMapping("{storeId}/admin/menu")
@Slf4j
public class MenuController
{
    @Autowired
    MenuService menuService;

    @Autowired
    CategoryService categoryService;

    @PostMapping("create")
    public boolean createMenu(@PathVariable(name = "storeId") String storeId, @RequestBody InsertMenuDTO data){
        log.debug("========dto======: {}", data);
        return menuService.createMenu(data);
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
        return menuService.deleteMenu(data);
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
        return menuService.deleteMenuOption(data);
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
        return menuService.updateMenu(data);
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
        return menuService.updateMenuOption(data);
    }

    /**
     * 카테고리별 메뉴 리스트 - 카테고리를 클릭하면 카테고리에 등록된 메뉴만 보여줌
     * 카테고리를 눌렀을 때 카테고리 번호 받아와야함 (categoryNum)
     * @param storeId
     * @param data
     * @return selectMenuList
     */
    @PostMapping("selectMenuList")
    public ArrayList<BacsMenu> selectMenuList(@PathVariable(name = "storeId") String storeId, @RequestBody Map<String, Integer> data)
    {

        int categoryNum = data.get("categoryNum");
        log.debug("categoryNum: {}", categoryNum);
        BacsMenu bacsMenu = new BacsMenu();
        bacsMenu.setCategoryNum(categoryNum);
        bacsMenu.setStoreId(storeId);

        ArrayList<BacsMenu> selectMenuList = menuService.selectMenuList(bacsMenu);
        return selectMenuList;
    }

    /**
     * 등록되어있는 메뉴 목록을 불러옴 (메뉴 수정 등)
     * @param storeId
     * @return menuList
     */
    @PostMapping("menuList")
    public ArrayList<BacsMenu> menuList (@PathVariable(name = "storeId") String storeId)
    {
        log.debug("storeId: {}", storeId);
       ArrayList<BacsMenu> menuList = menuService.menuList(storeId);
       return menuList;
    }
}