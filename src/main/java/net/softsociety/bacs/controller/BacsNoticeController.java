package net.softsociety.bacs.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.dto.notice.CreateNoticeDTO;
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

    /**
     * 전체 공지 생성
     * @param data
     */
    @PostMapping("create")
    public void create(@RequestBody CreateNoticeDTO data){

        log.debug("{}",data);
        service.create(data);
    }

    /**
     * 공지 삭제
     * @param data
     */
    @PostMapping("delete")
    public void delete(@RequestBody DeleteNoticeDTO data){
        log.debug("{}",data);
        service.delete(data);
    }

    /**
     * 공지 수정
     * @param data
     */
    @PostMapping("edit")
    public void edit(@RequestBody EditNoticeDTO data){
        log.debug("{}", data);
        service.edit(data);
    }

    /**
     * 공지 전체 리스트
     * 
     */

    @GetMapping("read")
    public ArrayList<BacsNotice> read(){

        ArrayList<BacsNotice> result = service.read();
        log.debug("** result: {}", result);
        return result;
    }

    /**
     * 공지 글 읽기
     * @param noticeNum
     * @return
     */
    @GetMapping("readone/{noticeNum}")
    public ArrayList<BacsNotice> readOne(@PathVariable("noticeNum") int noticeNum) {
        log.debug("{}", noticeNum);
        ArrayList<BacsNotice> notice = service.readOne(noticeNum);
        return notice;
    }

    // TODO: 회원 차단:수정상한테 넘어감

}
