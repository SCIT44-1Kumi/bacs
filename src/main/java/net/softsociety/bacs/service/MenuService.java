package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.BacsMenu;

import java.util.ArrayList;

public interface MenuService
{
    public String menuForm();

    ArrayList<BacsMenu> getMenuList(String storeId);
}
