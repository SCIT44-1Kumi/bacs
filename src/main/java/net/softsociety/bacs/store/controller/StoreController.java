package net.softsociety.bacs.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.store.dto.request.CreateStoreDTO;
import net.softsociety.bacs.store.dto.request.GetStoreDTO;
import net.softsociety.bacs.store.dto.response.StoreResponseDTO;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.service.StoreService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    // TODO: 매장 생성
    @PostMapping("create")
    public void createStore(@RequestBody @Valid CreateStoreDTO createStoreDTO) {
        storeService.createStore(createStoreDTO);
    }

    // TODO: 매장 삭제 cascade 매장 홈페이지, 키오스크 페이지, 카테고리, 메뉴, 주문 etc..

    // TODO: 매장 관리(Update)

    // TODO: 매장 가져오기
    @GetMapping("get/{storeId}")
    public StoreResponseDTO getStore(@PathVariable(name = "storeId") String storeId) {
        StoreResponseDTO store = storeService.getStore(storeId);
        log.debug("------controller store : {}", store);
        return store;
    }

    @GetMapping("get/byUser/{userId}")
    public StoreResponseDTO getStoreByUser(@PathVariable(name = "userId") String userId) {
        StoreResponseDTO store = storeService.getStoreByUser(userId);
        log.debug("------controller store : {}", store);
        return store;
    }

}
