package net.softsociety.bacs.storeNotice.service;

import net.softsociety.bacs.storeNotice.dto.CreateStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.dto.DeleteStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.dto.UpdateStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.entity.StoreNotice;

import java.util.List;

public interface StoreNoticeService {

    //매장 공지 작성
    void createStoreNotice(String storeId, CreateStoreNoticeDTO data);

    //매장 공지 수정
    void updateStoreNotice(String storeId, UpdateStoreNoticeDTO data);

    //매장 공지 삭제
    void deleteStoreNotice(String storeId, DeleteStoreNoticeDTO data);

    //매장 공지 리스트
    List<StoreNotice> selectStoreNotice(String storeId);

    //매장 공지 읽기
    StoreNotice readStoreNotice(long noticeNo);
}
