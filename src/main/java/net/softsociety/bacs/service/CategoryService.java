package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.vo.BacsCategory;
import net.softsociety.bacs.domain.dto.category.CreateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.SelectCategoryDTO;
import net.softsociety.bacs.domain.dto.category.UpdateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.DeleteCategoryDTO;
import net.softsociety.bacs.domain.vo.BacsMenu;

import java.util.ArrayList;

public interface CategoryService {

    //카테고리 등록
    public boolean createCategory(CreateCategoryDTO data);

    //카테고리 삭제
    public int deleteCategory(DeleteCategoryDTO data);

    //카테고리 수정
    public int updateCategory(UpdateCategoryDTO data);

    //카테고리별 메뉴 리스트
    ArrayList<BacsMenu> selectCategory(SelectCategoryDTO data);
}
