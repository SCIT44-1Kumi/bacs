package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.CategoryDAO;
import net.softsociety.bacs.domain.dto.category.CreateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.SelectCategoryDTO;
import net.softsociety.bacs.domain.dto.category.UpdateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.DeleteCategoryDTO;
import net.softsociety.bacs.domain.vo.BacsMenu;
import net.softsociety.bacs.domain.vo.BacsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    CategoryDAO dao;

    //카테고리 생성
    @Override
    public boolean createCategory(CreateCategoryDTO data)
    {
     return dao.createCategory(data);
    }

    //카테고리 삭제
    @Override
    public int deleteCategory(DeleteCategoryDTO category) {
        log.debug("서비스: {}",category);
        return dao.deleteCategory(category);
    }

    //카테고리 수정
    @Override
    public int updateCategory(UpdateCategoryDTO data) {
        return dao.updateCategory(data);
    }

    /**
     * 카테고리별 메뉴 리스트
     * @param data
     */
    @Override
    public ArrayList<BacsMenu> selectCategory(SelectCategoryDTO data) {
        return dao.selectCategory(data);
    }


}
