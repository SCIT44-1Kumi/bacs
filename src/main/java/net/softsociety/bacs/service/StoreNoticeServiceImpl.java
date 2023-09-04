package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.StoreNoticeDAO;
import net.softsociety.bacs.domain.dto.storeNotice.CreateStoreNoticeDTO;
import net.softsociety.bacs.domain.dto.storeNotice.DeleteStoreNoticeDTO;
import net.softsociety.bacs.domain.dto.storeNotice.UpdateStoreNoticeDTO;
import net.softsociety.bacs.domain.vo.StoreNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Slf4j
@Transactional
public class StoreNoticeServiceImpl implements StoreNoticeService
{
    @Autowired
    StoreNoticeDAO dao;

    /**
     * 매장 공지 생성
     * @param data
     */
    @Override
    public boolean createStoreNotice(CreateStoreNoticeDTO data) {
        return dao.createStoreNotice(data);
    }

    /**
     * 매장 공지 수정
     * @param data
     */
    @Override
    public int updateStoreNotice(UpdateStoreNoticeDTO data) {
        return dao.updateStoreNotice(data);
    }

    /**
     * 매장 공지 삭제
     * @param data
     */
    @Override
    public int deleteStoreNotice(DeleteStoreNoticeDTO data) {
        return dao.deleteStoreNotice(data);
    }

    /**
     * 매장 공지 리스트
     * @param storeId
     */
    @Override
    public ArrayList<StoreNotice> selectStoreNotice(String storeId) {
        return dao.selectStoreNotice(storeId);
    }

    /**
     * 매장 공지 읽기
     * @param noticeNum
     */
    @Override
    public ArrayList<StoreNotice> readStoreNotice(int noticeNum) {
        return dao.readStoreNotice(noticeNum);
    }


}
