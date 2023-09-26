package net.softsociety.bacs.notice.service;


import net.softsociety.bacs.notice.dto.CreateNoticeDTO;
import net.softsociety.bacs.notice.dto.DeleteNoticeDTO;
import net.softsociety.bacs.notice.dto.EditNoticeDTO;
import net.softsociety.bacs.notice.entity.Notice;

import java.util.List;


public interface NoticeService {

    /**
     * 
     * @param data
     * @return
     * 공지사항 생성
     */
    void create(CreateNoticeDTO data);

    /**
     * 공지사항 생성
     * @param data
     * @return
     */

    void edit(EditNoticeDTO data);

    /**
     * 공지사항 삭제
     * @param data
     * @return
     */
    void delete(DeleteNoticeDTO data);

    List<Notice> read();

    Notice readOne(int noticeNum);
}
