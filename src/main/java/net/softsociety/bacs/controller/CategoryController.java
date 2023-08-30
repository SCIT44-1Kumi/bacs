package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.BacsCategory;
import net.softsociety.bacs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public boolean createCategory(@RequestBody BacsCategory category)
    {
        log.debug("category {}",category);
        return service.createCategory(category);
    }
    // TODO: 카테고리 삭제
    // TODO: 카테고리 편집
    // TODO: 카테고리 리스트조회 where 매장아이디
}
