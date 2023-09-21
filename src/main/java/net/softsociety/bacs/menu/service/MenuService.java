package net.softsociety.bacs.menu.service;

import net.softsociety.bacs.domain.dto.menu.DeleteMenuDTO;
import net.softsociety.bacs.domain.dto.menu.DeleteMenuOptionDTO;
import net.softsociety.bacs.domain.dto.menu.InsertMenuDTO;
import net.softsociety.bacs.domain.vo.BacsMenu;
import net.softsociety.bacs.domain.vo.BacsMenuOption;

import java.util.ArrayList;

public interface MenuService {

    boolean createMenu(InsertMenuDTO data);

    //메뉴 삭제
    public int deleteMenu(DeleteMenuDTO data);

    //메뉴 옵션 삭제
    public int deleteMenuOption(DeleteMenuOptionDTO data);

    //메뉴 수정
    public int updateMenu(BacsMenu data);

    //메뉴 옵션 수정
    public int updateMenuOption(BacsMenuOption data);

    //카테고리별 메뉴 리스트
    ArrayList<BacsMenu> selectMenuList(BacsMenu bacsMenu);

    //등록된 메뉴 리스트
    ArrayList<BacsMenu> menuList(String storeId);
}
