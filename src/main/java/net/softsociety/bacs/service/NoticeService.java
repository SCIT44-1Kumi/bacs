package net.softsociety.bacs.service;


import net.softsociety.bacs.domain.dto.CreateNoticeDTO;
import net.softsociety.bacs.domain.dto.DeleteNoticeDTO;
import net.softsociety.bacs.domain.dto.EditNoticeDTO;
import net.softsociety.bacs.domain.vo.BacsNotice;

import java.util.ArrayList;


public interface NoticeService {

    /**
     * 
     * @param data
     * @return
     * 공지사항 생성
     */
    int create(CreateNoticeDTO data);

    /**
     * 공지사항 생성
     * @param data
     * @return
     */

    int edit(EditNoticeDTO data);

    /**
     * 공지사항 삭제
     * @param data
     * @return
     */
    int delete(DeleteNoticeDTO data);

    ArrayList<BacsNotice> read();

    ArrayList<BacsNotice> readOne(int noticeNum);
}
