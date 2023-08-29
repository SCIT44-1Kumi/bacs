package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.MenuDAO;
import net.softsociety.bacs.domain.BacsMenu;
import net.softsociety.bacs.domain.BacsMenuOption;
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
     * @param menu 생성할 메뉴객체
     * @param options 메뉴와 함션 생성할 메뉴 옵션 배열
     * @return boolean
     */
    @Override
    public boolean createMenu(BacsMenu menu, ArrayList<BacsMenuOption> options) {
        menu.setStoreId("scitcafe");
        menu.setCategoryNum(String.valueOf(1));
        log.debug("=======메뉴=======: {}", menu);
        int n = dao.createMenu(menu);
        log.debug("=======메뉴=======: {}, {}", n, menu);
        for(BacsMenuOption option : options) {
            option.setMenuNum(menu.getMenuNum());
            log.debug("{}", option);
        }
        int m = dao.createOptions(options);
        return n != 0;
    }
}
