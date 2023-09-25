package net.softsociety.bacs.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.admin.dto.BlockStoreDTO;
import net.softsociety.bacs.admin.dto.DeleteStoreDTO;
import net.softsociety.bacs.admin.service.AdminService;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("admin")
@RequiredArgsConstructor
public class BacsAdminController {

    private final UserService service;

    private final AdminService adminService;

    // 매장 조회 /store/list
    @GetMapping("store/list")
    public List<Store> getStoreList() {
        return adminService.getStoreList();
    }

    // 매장 삭제 /store/delete
    @PostMapping("store/delete")
    public void deleteStore(@RequestBody @Valid DeleteStoreDTO storeId) {
        adminService.deleteStore(storeId);
    }

    // 매장(회원)차단 /store/block
    @PostMapping("store/block")
    public void blockStore(@RequestBody BlockStoreDTO dto) {
        adminService.blockStore(dto);
    }

    // 매장 차단해제 /store/rebock
    @PostMapping("store/rebock")
    public void rebockStore(@RequestBody BlockStoreDTO dto) {
        adminService.rebockStore(dto);
    }



    /**
     * 당일 매출 조회
     * @param data
     * @return data
     */
//    @PostMapping("saleToday")
//    public int saleToday(@RequestBody SaleTodayDTO data) {
//       return service.saleToday(data);
//
//    }
//
//    // TODO: 통계 조회 개발중
//
//    @PostMapping("salesWeek")
//    public int salesWeek(@RequestBody SaleTodayDTO data){
//        return service.salesWeek(data);
//    }
}
