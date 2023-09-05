package net.softsociety.bacs.dao;

import net.softsociety.bacs.domain.dto.notice.CreateNoticeDTO;
import net.softsociety.bacs.domain.dto.DeleteNoticeDTO;
import net.softsociety.bacs.domain.dto.EditNoticeDTO;
import net.softsociety.bacs.domain.vo.BacsNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface NoticeDAO {

    int create(CreateNoticeDTO data);
    int delete(DeleteNoticeDTO data);
    int edit(EditNoticeDTO data);
    ArrayList<BacsNotice> read();

    ArrayList<BacsNotice> readOne(int noticeNum);
}
