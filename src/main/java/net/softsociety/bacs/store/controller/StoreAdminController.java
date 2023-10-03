package net.softsociety.bacs.store.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.store.dto.SaleTodayDTO;
import net.softsociety.bacs.store.service.StoreAdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("{storeId}/admin")
public class StoreAdminController {

    @Autowired
    StoreAdminService service;

    // TODO: 관리자 페이지 조회
    @GetMapping("statics")
    public void getStatics(@PathVariable(name = "storeId") String storeId) {

    }

    // TODO: 당일매출조회

    @PostMapping("saleToday")
    public Optional<Long> saleToday(@PathVariable(name = "storeId") String storeId){
        log.debug("{}",storeId);
        return service.saleToday(storeId);
    }

    @PostMapping("salesWeek")
    public Optional<Long> salesWeek(@PathVariable(name = "storeId") String storeId){
        return service.salesWeek(storeId);
    }
}
