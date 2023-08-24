package net.softsociety.bacs.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDAO
{
    void menuInsert(BacsMenu menu);

    void menuOptionInsert(BacsMenuOption menuOption);
}
