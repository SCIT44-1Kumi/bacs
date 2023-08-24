package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService
{
    @Autowired
    MenuDAO dao;


    /**
     * @param menu
     */
    @Override
    public void menuInsert(BacsMenu menu) {
        dao.menuInsert(menu);
    }

    /**
     * @param menuOption
     */
    @Override
    public void menuOptionInsert(BacsMenuOption menuOption) {
        dao.menuOptionInsert(menuOption);
    }
}
