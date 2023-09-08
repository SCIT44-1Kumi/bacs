package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.dto.SaleTodayDTO;
import net.softsociety.bacs.domain.dto.admin.BlockStoreDTO;
import net.softsociety.bacs.domain.dto.admin.DeleteStoreDTO;
import net.softsociety.bacs.domain.vo.BacsStore;
import net.softsociety.bacs.service.AdminService;
import net.softsociety.bacs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("admin")
public class BacsAdminController {

    @Autowired
    UserService service;

    @Autowired
    AdminService adminService;

    // 매장 조회 /store/list
    @GetMapping("store/list")
    public ArrayList<BacsStore> getStoreList() {
        return adminService.getStoreList();
    }

    // 매장 삭제 /store/delete
    @PostMapping("store/delete")
    public boolean deleteStore(@RequestBody DeleteStoreDTO storeId) {
        return adminService.deleteStore(storeId);
    }

    // 매장(회원)차단 /store/block
    @PostMapping("store/block")
    public boolean blockStore(@RequestBody BlockStoreDTO userId) {
        return adminService.blockStore(userId);
    }

    // 매장 차단해제 /store/rebock
    @PostMapping("store/rebock")
    public boolean rebockStore(@RequestBody BlockStoreDTO userId) {
        return adminService.rebockStore(userId);
    }



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
