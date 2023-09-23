package net.softsociety.bacs.category.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.category.dao.CategoryDAO;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.category.entity.CategoryRepository;
import net.softsociety.bacs.category.exception.CategoryErrorCode;
import net.softsociety.bacs.domain.dto.category.CreateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.SelectCategoryDTO;
import net.softsociety.bacs.domain.dto.category.UpdateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.DeleteCategoryDTO;
import net.softsociety.bacs.domain.vo.BacsCategory;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService
{

    CategoryDAO dao;
    private final CategoryRepository categoryRepository;
    private final StoreRepository storeRepository;

    //카테고리 생성
    @Override
    public boolean createCategory(CreateCategoryDTO dto) {
        // 매장 존재 여부 검사
        Store store = storeRepository.findByStoreId(dto.storeId())
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        // 같은 이름의 카테고리 존재 여부 검사
        if(categoryRepository.findByCategoryNameAndStoreId(dto.categoryName(), dto.storeId()).isPresent()){
            throw CategoryErrorCode.CATEGORY_CONFLICT.defaultException();
        }

        // 카테고리 객체 생성
        Category category = Category.builder()
                .categoryName(dto.categoryName())
                .build();

        // DB에 카테고리 등록
        categoryRepository.save(category);

        // 매장에 카테고리 등록
        store.addCategory(category);
        storeRepository.save(store);
     return true;
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
    public ArrayList<BacsCategory> selectCategory(SelectCategoryDTO data) {
        return dao.selectCategory(data);
    }
}
