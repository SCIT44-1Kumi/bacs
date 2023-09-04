package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.dto.menu.DeleteMenuDTO;
import net.softsociety.bacs.domain.dto.menu.DeleteMenuOptionDTO;
import net.softsociety.bacs.domain.vo.BacsMenu;
import net.softsociety.bacs.domain.vo.BacsMenuOption;

import java.util.ArrayList;

public interface MenuService {

    boolean createMenu(BacsMenu menu, ArrayList<BacsMenuOption> options);

    //메뉴 삭제
    public int deleteMenu(DeleteMenuDTO data);

    //메뉴 옵션 삭제
    public int deleteMenuOption(DeleteMenuOptionDTO data);

    //메뉴 수정
    public int updateMenu(BacsMenu data);

    //메뉴 옵션 수정
    public int updateMenuOption(BacsMenuOption data);
}
