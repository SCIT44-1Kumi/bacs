package net.softsociety.bacs.dao;

import net.softsociety.bacs.domain.BacsMenu;
import net.softsociety.bacs.domain.BacsMenuOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MenuDAO
{
//    public void menuInsert(BacsMenu menu);
//
//    public void menuOptionInsert(BacsMenuOption menuOption);

    int createMenu(BacsMenu menu);

    int createOptions(ArrayList<BacsMenuOption> options);
}
