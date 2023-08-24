package net.softsociety.bacs.dao;

import net.softsociety.bacs.domain.BacsMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MenuDAO
{
    public String menuForm();

    public ArrayList<BacsMenu> getMenuList(String storeId);
}
