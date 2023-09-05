package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
import net.softsociety.bacs.domain.dto.storeNotice.CreateStoreNoticeDTO;
import net.softsociety.bacs.domain.dto.storeNotice.DeleteStoreNoticeDTO;
import net.softsociety.bacs.domain.dto.storeNotice.UpdateStoreNoticeDTO;
import net.softsociety.bacs.domain.vo.StoreNotice;
import net.softsociety.bacs.service.StoreNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("") // TODO: "매장아이디"/notice
public class StoreNoticeController {

    @Autowired
    StoreNoticeService service;

    /**
     * 매장 공지 생성
     * @param data
     * @return
     */
    @PostMapping("createStoreNotice")
    public boolean createStoreNotice(@RequestBody CreateStoreNoticeDTO data)
    {
        log.debug("category {}",data);
        return service.createStoreNotice(data);
    }


    /**
     * 매장 공지 삭제
     * 글 번호, 스토어 아이디를 받아와서 글 삭제
     * @param data
     */
    @PostMapping("deleteStoreNotice")
    public int deleteStoreNotice(@RequestBody DeleteStoreNoticeDTO data)
    {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        return service.deleteStoreNotice(data);
    }


    /**
     * 매장 공지 편집
     * 공지 번호와 storeId를 받아가서 수정
     * @param data
     */
    @PostMapping("updateStoreNotice")
    public int updateStoreNotice(@RequestBody UpdateStoreNoticeDTO data)
    {
        // TODO : 접속자 아이디와 글 쓴 사람 아이디 비교 (로그인 상태가 아니거나 다르면 false)
        return service.updateStoreNotice(data);
    }

    /**
     * 매장 공지 리스트조회
     * storeID를 받아와서 매장 공지 리스트 검색
     * @param storeId
     */
    @GetMapping("SelectStoreNotice/{storeId}")
    public ArrayList<StoreNotice> selectStoreNotice(@PathVariable("storeId") String storeId)
    {
        // TODO : storeID 받아와야함
        log.debug("storeId: {}", storeId);
        ArrayList<StoreNotice> selectStoreNoticeList = service.selectStoreNotice(storeId);
        return selectStoreNoticeList;
    }

    /**
     * 매장 공지 읽기
     * storeNum 받아와서 공지 읽기
     *
     * @param noticeNum
     */
    @GetMapping("ReadStoreNotice/{noticeNum}")
    public ArrayList<StoreNotice> readStoreNotice(@PathVariable("noticeNum") int noticeNum)
    {
        // TODO : 글 번호 (noticeNum) 받아와야함
        log.debug("글번호: {}", noticeNum);
        ArrayList<StoreNotice> storeNotice = service.readStoreNotice(noticeNum);
        return storeNotice;
    }


}
