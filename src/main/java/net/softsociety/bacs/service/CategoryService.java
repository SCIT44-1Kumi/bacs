package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.BacsCategory;

public interface CategoryService {

    //카테고리 등록
    public boolean createCategory(BacsCategory category);
}
