package net.softsociety.bacs.menu.service;

import net.softsociety.bacs.menu.dto.*;


import net.softsociety.bacs.menu.dto.response.MenuOptionResponseDTO;
import net.softsociety.bacs.menu.dto.response.MenuResponseDTO;
import net.softsociety.bacs.menu.entity.menu.Menu;




import java.util.List;

public interface MenuService {

    void createMenu(String storeId, InsertMenuDTO data);

    //메뉴 삭제
    void deleteMenu(String storeId, DeleteMenuDTO data);

    //메뉴 옵션 삭제
    void deleteMenuOption(DeleteMenuOptionDTO data);

    //메뉴 수정
    void updateMenu(String storeId,  UpdateMenuDTO data);

    //메뉴 옵션 수정
    void updateMenuOption(UpdateMenuOptionDTO dto);

    //카테고리별 메뉴 리스트
    List<Menu> selectMenuList(String storeId, GetMenusDTO dto);

    List<MenuResponseDTO> getMenuList(long dto);

    List<MenuOptionResponseDTO> getMenuOptions(long menuId);
}
