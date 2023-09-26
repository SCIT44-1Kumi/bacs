package net.softsociety.bacs.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.notice.dto.CreateNoticeDTO;
import net.softsociety.bacs.notice.dto.DeleteNoticeDTO;
import net.softsociety.bacs.notice.dto.EditNoticeDTO;
import net.softsociety.bacs.notice.entity.Notice;
import net.softsociety.bacs.notice.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("notice")
@RequiredArgsConstructor
public class BacsNoticeController {

    private final NoticeService service;

    /**
     * 전체 공지 생성
     * @param data
     */
    @PostMapping("create")
    public void create(@RequestBody @Valid CreateNoticeDTO dto){
        log.debug("{}",dto);
        service.create(dto);
    }

    /**
     * 공지 삭제
     * @param data
     */
    @PostMapping("delete")
    public void delete(@RequestBody @Valid DeleteNoticeDTO dto){
        log.debug("{}",dto);
        service.delete(dto);
    }

    /**
     * 공지 수정
     * @param data
     */
    @PostMapping("edit")
    public void edit(@RequestBody @Valid EditNoticeDTO data){
        log.debug("{}", data);
        service.edit(data);
    }

    /**
     * 공지 전체 리스트
     * 
     */

    @GetMapping("read")
    public List<Notice> read(){
        List<Notice> result = service.read();
        log.debug("** result: {}", result);
        return result;
    }

    /**
     * 공지 글 읽기
     * @param noticeNum
     * @return
     */
    @GetMapping("readone/{noticeNum}")
    public Notice readOne(@PathVariable("noticeNum") int noticeNum) {
        log.debug("{}", noticeNum);
        return service.readOne(noticeNum);
    }

    // TODO: 회원 차단:수정상한테 넘어감

}
