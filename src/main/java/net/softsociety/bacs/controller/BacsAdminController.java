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

    // TODO: 매장 조회 /store/list
    // TODO: 매장삭제 /store/delete
    // TODO: 매장차단 /store/block

    /**
     * 당일 매출 조회
     * @param data
     * @return data
     */
    @PostMapping("saleToday")
    public int saleToday(@RequestBody SaleTodayDTO data){
       return service.saleToday(data);

    }

    // TODO: 통계 조회 개발중
     
    @PostMapping("salesWeek")
    public int salesWeek(@RequestBody SaleTodayDTO data){
        return service.salesWeek(data);
    }
}
