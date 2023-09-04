package net.softsociety.bacs.dao;

import net.softsociety.bacs.domain.dto.category.CreateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.SelectCategoryDTO;
import net.softsociety.bacs.domain.dto.category.UpdateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.DeleteCategoryDTO;
import net.softsociety.bacs.domain.vo.BacsMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface CategoryDAO
{
    //카테고리 등록
    boolean createCategory(CreateCategoryDTO data);

    //카테고리 삭제
    int deleteCategory(DeleteCategoryDTO data);

    //카테고리 수정
    int updateCategory(UpdateCategoryDTO data);

    //카테고리별 메뉴 리스트
    ArrayList<BacsMenu> selectCategory(SelectCategoryDTO data);
}
