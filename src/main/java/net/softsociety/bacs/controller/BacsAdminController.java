package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.dto.SaleTodayDTO;
import net.softsociety.bacs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("admin")
public class BacsAdminController {

    @Autowired
    UserService service;

    // TODO: 매장 홈페이지 생성
    // TODO: 매장 홈페이지 삭제
    // TODO: 매장 홈페이지 편집
    // TODO: 키오스크 페이지 생성
    // TODO: 키오스크 페이지 삭제
    // TODO: 키오스크 페이지 편집
    // TODO: 매출 조회
    @PostMapping("saleToday")
    public int saleToday(@RequestBody SaleTodayDTO data){
       return service.saleToday(data);

    }
    // TODO: 통계 조회
    @PostMapping("salesWeek")
    public int salesWeek(@RequestBody SaleTodayDTO data){
        return service.salesWeek(data);
    }
}
