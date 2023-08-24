package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.MenuDAO;
import net.softsociety.bacs.domain.BacsMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService
{
    @Autowired
    MenuDAO dao;

    /**
     * @return
     */
    @Override
    public String menuForm() {
        return null;
    }

    /**
     * @param storeId
     * @return
     */
    @Override
    public ArrayList<BacsMenu> getMenuList(String storeId) {
        return dao.getMenuList(storeId);
    }
}
