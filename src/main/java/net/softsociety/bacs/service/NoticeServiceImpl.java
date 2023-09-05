package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.NoticeDAO;
import net.softsociety.bacs.domain.dto.notice.CreateNoticeDTO;
import net.softsociety.bacs.domain.dto.DeleteNoticeDTO;
import net.softsociety.bacs.domain.dto.EditNoticeDTO;
import net.softsociety.bacs.domain.vo.BacsNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Slf4j
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeDAO dao;

    @Override
    public int create(CreateNoticeDTO data) {
        return dao.create(data);
    }

    @Override
    public int delete(DeleteNoticeDTO data) {return dao.delete(data);}

    @Override
    public ArrayList<BacsNotice> read() {
        ArrayList<BacsNotice> result2 = dao.read();
        return result2;
    }


    @Override
    public int edit(EditNoticeDTO data) {return dao.edit(data); }

    @Override
    public ArrayList<BacsNotice> readOne(int noticeNum){
        ArrayList<BacsNotice> result = dao.readOne(noticeNum);
        return result;
    }

}
