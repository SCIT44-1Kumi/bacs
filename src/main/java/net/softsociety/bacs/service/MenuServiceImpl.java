package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.MenuDAO;
import net.softsociety.bacs.domain.dto.menu.DeleteMenuDTO;
import net.softsociety.bacs.domain.dto.menu.DeleteMenuOptionDTO;
import net.softsociety.bacs.domain.dto.menu.InsertMenuDTO;
import net.softsociety.bacs.domain.vo.BacsMenu;
import net.softsociety.bacs.domain.vo.BacsMenuOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Slf4j
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO dao;

    /**
     * @param data 생성할 메뉴객체, 메뉴와 함션 생성할 메뉴 옵션 배열
     * @return boolean
     */
    @Override
    public boolean createMenu(InsertMenuDTO data) {
        BacsMenu menu = data.getMenu();
        ArrayList<BacsMenuOption> options = data.getOptions();
        menu.setCategoryNum(data.getCategoryNum());
        int n = dao.createMenu(menu);
        log.debug("=======메뉴=======: {}, {}", n, menu);
        for(BacsMenuOption option : options) {
            option.setMenuNum(menu.getMenuNum());
            log.debug("{}", option);
        }
        int m = dao.createOptions(options);
        return n != 0;
    }

    /**
     * 메뉴 삭제
     * @param data
     */
    @Override
    public int deleteMenu(DeleteMenuDTO data) {
        return dao.deleteMenu(data);
    }

    /**
     * 메뉴 옵션 삭제
     * @param data
     */
    @Override
    public int deleteMenuOption(DeleteMenuOptionDTO data) {
        return dao.deleteMenuOption(data);
    }

    /**
     * 메뉴 수정
     * @param data
     */
    @Override
    public int updateMenu(BacsMenu data) {
        return dao.updateMenu(data);
    }

    /**
     * 메뉴 옵션 수정
     * @param data
     */
    @Override
    public int updateMenuOption(BacsMenuOption data) {
        return dao.updateMenuOption(data);
    }


    /**
     * 카테고리별 메뉴 리스트
     * @param bacsMenu
     * @return
     */
    @Override
    public ArrayList<BacsMenu> selectMenuList(BacsMenu bacsMenu) {
        return dao.selectmenuList(bacsMenu);
    }

    /**
     * 등록된 메뉴 리스트
     * @param storeId
     * @return
     */
    @Override
    public ArrayList<BacsMenu> menuList(String storeId) {
        return dao.menuList(storeId);
    }
}
