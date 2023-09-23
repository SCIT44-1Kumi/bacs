package net.softsociety.bacs.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.vo.BacsStore;
import net.softsociety.bacs.store.dto.CreateStoreDTO;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    // TODO: 매장 생성
    @PostMapping("create")
    public Store createStore(@RequestBody CreateStoreDTO createStoreDTO) {
        return storeService.createStore(createStoreDTO);
    }

    // TODO: 매장 삭제 cascade 매장 홈페이지, 키오스크 페이지, 카테고리, 메뉴, 주문 etc..
    // TODO: 매장 관리(Update)

}
