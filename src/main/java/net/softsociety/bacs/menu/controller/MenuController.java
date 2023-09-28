package net.softsociety.bacs.menu.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.menu.dto.*;
import net.softsociety.bacs.menu.entity.Menu;
import net.softsociety.bacs.menu.service.MenuService;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("{storeId}/admin/menu")
@Slf4j
@RequiredArgsConstructor
public class MenuController
{

    private final MenuService menuService;

    @PostMapping("create")
    public void createMenu(@PathVariable(name = "storeId") String storeId, @RequestBody @Valid InsertMenuDTO data){
        log.debug("========dto======: {}", data);
        menuService.createMenu(storeId, data);
    }

    /**
     * 메뉴 삭제
     * 아이디와 메뉴 번호를 받아가서 메뉴 삭제
     * @param data
     */
    @PostMapping("deleteMenu")
    public void deleteMenu(@PathVariable(name = "storeId") String storeId, @RequestBody @Valid DeleteMenuDTO data)
    {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        // TODO : 이미지 삭제 처리
        log.debug("DTO: {}", data);
        menuService.deleteMenu(storeId, data);
    }

    /**
     * 메뉴 옵션 삭제
     * 옵션 번호와 메뉴 번호를 받아가서 메뉴 옵션 삭제
     * @param data
     */
    @PostMapping("deleteMenuOption")
    public void deleteMenuOption(@RequestBody @Valid DeleteMenuOptionDTO data)
    {
        log.debug("DTO: {}", data);
        menuService.deleteMenuOption(data);
    }


    /**
     * 메뉴 수정
     * 아이디와 메뉴 번호를 받아가서 메뉴 수정
     * (VO의 내용이 다 필요해서 DTO안만듦)
     * @param dto
     */
    @PostMapping("updateMenu")
    public void updateMenu(@PathVariable(name = "storeId") String storeId, @RequestBody @Valid UpdateMenuDTO dto)
    {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        // TODO : 이미지 경로 수정 처리
        log.debug("updateMenu: {}", dto);
        menuService.updateMenu(storeId, dto);
    }

    /**
     * 메뉴 옵션 수정
     * 옵션 번호 메뉴 번호를 받아가서 메뉴 옵션 수정
     * (VO의 내용이 다 필요해서 DTO안만듦)
     * @param dto
     */
    @PostMapping("updateMenuOption")
    public void updateMenuOption(@RequestBody @Valid UpdateMenuOptionDTO dto)
    {
        log.debug("updateMenuOption: {}", dto);
        menuService.updateMenuOption(dto);
    }

    /**
     * 카테고리별 메뉴 리스트 - 카테고리를 클릭하면 카테고리에 등록된 메뉴만 보여줌
     * 카테고리를 눌렀을 때 카테고리 번호 받아와야함 (categoryNum)
     * @param storeId
     * @param dto
     * @return selectMenuList
     */
    @PostMapping("selectMenuList")
    public List<Menu> selectMenuList(@PathVariable(name = "storeId") String storeId, @RequestBody @Valid GetMenusDTO dto)
    {
        return menuService.selectMenuList(storeId, dto);
    }
}