package net.softsociety.bacs.category.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.category.dto.response.CategoryResponseDTO;
import net.softsociety.bacs.category.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{storeId}/category")
@Slf4j
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;


    /**
     * 카테고리별 리스트조회 where 매장아이디
     * categoryNum과 storeID를 받아와서 리스트 검색
     *
     * @param storeId
     */
    @GetMapping("getCategories")
    public List<CategoryResponseDTO> selectCategoryList (@PathVariable(name = "storeId") String storeId) {
        return service.getCategory(storeId);
    }
}
