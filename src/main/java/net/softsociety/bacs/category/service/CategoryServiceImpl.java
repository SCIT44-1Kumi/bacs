package net.softsociety.bacs.category.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.category.entity.CategoryRepository;
import net.softsociety.bacs.category.exception.CategoryErrorCode;
import net.softsociety.bacs.category.dto.CreateCategoryDTO;
import net.softsociety.bacs.category.dto.UpdateCategoryDTO;
import net.softsociety.bacs.category.dto.DeleteCategoryDTO;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService
{

    private final CategoryRepository categoryRepository;
    private final StoreRepository storeRepository;

    //카테고리 생성
    @Override
    public boolean createCategory(String storeId, CreateCategoryDTO dto) {
        // 매장 존재 여부 검사
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        log.debug("--------store : {}", store);

        // 같은 이름의 카테고리 존재 여부 검사
        if(categoryRepository.findByCategoryNameAndStore(dto.categoryName(), store).isPresent()){
            throw CategoryErrorCode.CATEGORY_CONFLICT.defaultException();
        }

        // 카테고리 객체 생성
        Category category = Category.builder()
                .categoryName(dto.categoryName())
                .store(store)
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
    public void deleteCategory(String storeId, DeleteCategoryDTO dto) {
        log.debug("서비스: {}", dto);
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        Category category = categoryRepository
                .findByCategoryNumAndStore(dto.categoryNum(), store)
                .orElseThrow(CategoryErrorCode.CATEGORY_NULL::defaultException);
        categoryRepository.delete(category);
    }

    //카테고리 수정
    @Override
    public void updateCategory(String storeId, UpdateCategoryDTO dto) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        Category category = categoryRepository
                .findByCategoryNumAndStore(dto.categoryNum(), store)
                .orElseThrow(CategoryErrorCode.CATEGORY_NULL::defaultException);

        category.update(dto.categoryName());
    }

    /**
     * 카테고리별 메뉴 리스트
     *
     * @param storeId
     */
    @Override
    public List<Category> selectCategory(String storeId) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        return categoryRepository.findByStore_id(store);
    }
}
