package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.BacsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
@Slf4j
public class CategoryController {

    @Autowired
    CategoryService service;

    // TODO: 카테고리 생성
    @PostMapping("create")
    public boolean createCategory(BacsCategory category) {
        return service.createCategory(category);
    }
    // TODO: 카테고리 삭제
    // TODO: 카테고리 편집
    // TODO: 카테고리 리스트조회 where 매장아이디
}
