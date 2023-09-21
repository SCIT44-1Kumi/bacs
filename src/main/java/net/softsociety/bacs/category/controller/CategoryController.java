package net.softsociety.bacs.category.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.dto.category.CreateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.SelectCategoryDTO;
import net.softsociety.bacs.domain.dto.category.UpdateCategoryDTO;
import net.softsociety.bacs.domain.dto.category.DeleteCategoryDTO;
import net.softsociety.bacs.domain.vo.BacsCategory;
import net.softsociety.bacs.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("{storeId}/admin/category")
@Slf4j
public class CategoryController {

    @Autowired
    CategoryService service;

    /**
     * 카테고리 생성
     * 카테고리 이름, 스토어 아이디 받아옴
     * @param data
     */
    @PostMapping("create")
    public boolean createCategory(@PathVariable(name = "storeId") String storeId, @RequestBody CreateCategoryDTO data) {
        data.setStoreId(storeId);
        log.debug("category {}",data);
        return service.createCategory(data);
    }

    /**
     * 카테고리 삭제
     * 카테고리 번호(SEQ), 스토어 아이디 받아옴
     * @param data
     */
    @PostMapping("delete")
    public int deleteCategory(@PathVariable(name = "storeId") String storeId, @RequestBody DeleteCategoryDTO data) {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        data.setStoreId(storeId);
        log.debug("DTO: {}", data);
        return service.deleteCategory(data);
    }

    /**
     * 카테고리 수정
     * 카테고리 번호, 바꿀 이름, 스토어 아이디 받아옴
     * @param data
     */
    @PostMapping("update")
    public int updateCategory(@PathVariable(name = "storeId") String storeId, @RequestBody UpdateCategoryDTO data) {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        data.setStoreId(storeId);
        return service.updateCategory(data);
    }

    /**
     * 카테고리별 리스트조회 where 매장아이디
     * categoryNum과 storeID를 받아와서 리스트 검색
     *
     * @param data
     */
    @PostMapping("getCategories")
    public ArrayList<BacsCategory> selectCategoryList (@PathVariable(name = "storeId") String storeId, @RequestBody SelectCategoryDTO data) {
        data.setStoreId(storeId);
        return service.selectCategory(data);
    }
}
