package net.softsociety.bacs.category.service;

import net.softsociety.bacs.category.dto.response.CategoryResponseDTO;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.category.dto.CreateCategoryDTO;
import net.softsociety.bacs.category.dto.UpdateCategoryDTO;
import net.softsociety.bacs.category.dto.DeleteCategoryDTO;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {

    //카테고리 등록
    public boolean createCategory(String storeId, CreateCategoryDTO data);

    //카테고리 삭제
    public void deleteCategory(String storeId, DeleteCategoryDTO data);

    //카테고리 수정
    public void updateCategory(String storeId, UpdateCategoryDTO data);

    //카테고리별 메뉴 리스트
    List<Category> selectCategory(String data);
    List<CategoryResponseDTO> getCategory(String data);
}
