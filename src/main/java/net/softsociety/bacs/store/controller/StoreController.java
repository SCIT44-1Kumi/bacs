package net.softsociety.bacs.store.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.vo.BacsStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("store")
public class StoreController {

    // TODO: 매장 생성
    // TODO: 매장 삭제 cascade 매장 홈페이지, 키오스크 페이지, 카테고리, 메뉴, 주문 etc..
    // TODO: 매장 관리(Update)

}