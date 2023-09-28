package net.softsociety.bacs.category.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.category.dto.CreateCategoryDTO;
import net.softsociety.bacs.category.dto.UpdateCategoryDTO;
import net.softsociety.bacs.category.dto.DeleteCategoryDTO;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.category.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("{storeId}/admin/category")
@Slf4j
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService service;

    /**
     * 카테고리 생성
     * 카테고리 이름, 스토어 아이디 받아옴
     * @param data
     */
    @PostMapping("create")
    public boolean createCategory(@PathVariable(name = "storeId") String storeId, @RequestBody @Valid CreateCategoryDTO data) {
        log.debug("--------dto {}",data);
        return service.createCategory(storeId, data);
    }

    /**
     * 카테고리 삭제
     * 카테고리 번호(SEQ), 스토어 아이디 받아옴
     * @param data
     */
    @PostMapping("delete")
    public void deleteCategory(@PathVariable(name = "storeId") String storeId, @RequestBody @Valid DeleteCategoryDTO data) {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        log.debug("---------DTO: {}", data);
        service.deleteCategory(storeId, data);
    }

    /**
     * 카테고리 수정
     * 카테고리 번호, 바꿀 이름, 스토어 아이디 받아옴
     * @param data
     */
    @PostMapping("update")
    public void updateCategory(@PathVariable(name = "storeId") String storeId, @RequestBody @Valid UpdateCategoryDTO data) {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        service.updateCategory(storeId, data);
    }

    /**
     * 카테고리별 리스트조회 where 매장아이디
     * categoryNum과 storeID를 받아와서 리스트 검색
     *
     * @param storeId
     */
    @PostMapping("getCategories")
    public List<Category> selectCategoryList (@PathVariable(name = "storeId") String storeId) {
        return service.selectCategory(storeId);
    }
}
