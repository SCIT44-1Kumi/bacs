package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.dto.CreateNoticeDTO;
import net.softsociety.bacs.domain.dto.DeleteNoticeDTO;
import net.softsociety.bacs.domain.dto.EditNoticeDTO;
import net.softsociety.bacs.domain.vo.BacsNotice;
import net.softsociety.bacs.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;


@RestController
@Slf4j
@RequestMapping("notice")
public class BacsNoticeController {

    @Autowired
    NoticeService service;

    // TODO: 메인 공지 생성
    @PostMapping("create")
    public void create(@RequestBody CreateNoticeDTO data){

        log.debug("{}",data);
        service.create(data);
    }
    // TODO: 메인 공지 삭제
    @PostMapping("delete")
    public void delete(@RequestBody DeleteNoticeDTO data){
        log.debug("{}",data);
        service.delete(data);
    }
    // TODO: 메인 공지 편집
    @PostMapping("edit")
    public void edit(@RequestBody EditNoticeDTO data){
        log.debug("{}", data);
        service.edit(data);
    }
    // TODO: 메인 공지 리스트조회

    @GetMapping("read")
    public ArrayList<BacsNotice> read(){

        ArrayList<BacsNotice> result = service.read();
        log.debug("** result: {}", result);
        return result;
    }

    // TODO: 메인 공지 조회
    @GetMapping("readone/{noticeNum}")
    public ArrayList<BacsNotice> readOne(@PathVariable("noticeNum") int noticeNum) {
        log.debug("{}", noticeNum);
        ArrayList<BacsNotice> notice = service.readOne(noticeNum);
        return notice;
    }

    // TODO: 회원 차단

}
