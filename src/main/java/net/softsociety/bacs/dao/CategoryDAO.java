package net.softsociety.bacs.dao;

import net.softsociety.bacs.domain.BacsCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDAO
{
    public boolean createCategory(BacsCategory category);
}
