package net.softsociety.bacs.storeNotice.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.storeNotice.dto.CreateStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.dto.DeleteStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.dto.UpdateStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.entity.StoreNotice;
import net.softsociety.bacs.storeNotice.service.StoreNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@Slf4j
@RequestMapping("{storeId}/notice") // "매장아이디"/notice
public class StoreNoticeController {

    @Autowired
    StoreNoticeService service;

    /**
     * 매장 공지 생성
     * @param data
     * @return
     */
    @PostMapping("createStoreNotice")
    public void createStoreNotice(@PathVariable(name = "storeId") String storeId, @RequestBody @Valid CreateStoreNoticeDTO data) {
        service.createStoreNotice(storeId, data);
    }


    /**
     * 매장 공지 삭제
     * 글 번호, 스토어 아이디를 받아와서 글 삭제
     * @param data
     */
    @PostMapping("deleteStoreNotice")
    public void deleteStoreNotice(@PathVariable(name = "storeId") String storeId, @RequestBody DeleteStoreNoticeDTO data) {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        service.deleteStoreNotice(storeId, data);
    }


    /**
     * 매장 공지 편집
     * 공지 번호와 storeId를 받아가서 수정
     * @param data
     */
    @PostMapping("updateStoreNotice")
    public void updateStoreNotice(@PathVariable(name = "storeId") String storeId, @RequestBody @Valid UpdateStoreNoticeDTO data) {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        service.updateStoreNotice(storeId, data);
    }

    /**
     * 매장 공지 리스트조회
     * storeID를 받아와서 매장 공지 리스트 검색
     * @param storeId
     */
    @GetMapping("SelectStoreNotice")
    public List<StoreNotice> selectStoreNotice(@PathVariable(name = "storeId") String storeId) {
        log.debug("storeId: {}", storeId);
        return service.selectStoreNotice(storeId);
    }

    /**
     * 매장 공지 읽기
     * storeNum 받아와서 공지 읽기
     *
     * @param noticeNum
     */
    @GetMapping("ReadStoreNotice/{noticeNum}")
    public StoreNotice readStoreNotice(@PathVariable(name = "storeId") String storeId, @PathVariable int noticeNum) {
        log.debug("글번호: {}", noticeNum);
        return service.readStoreNotice(noticeNum);
    }


}
