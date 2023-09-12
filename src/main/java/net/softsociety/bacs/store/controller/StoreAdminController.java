package net.softsociety.bacs.store.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.store.service.StoreAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
