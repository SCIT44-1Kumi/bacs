package net.softsociety.bacs.storeNotice.service;

import net.softsociety.bacs.storeNotice.dto.CreateStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.dto.DeleteStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.dto.UpdateStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.entity.StoreNotice;

import java.util.List;

public interface StoreNoticeService {

    //매장 공지 작성
    public void createStoreNotice(String storeId, CreateStoreNoticeDTO data);

    //매장 공지 수정
    public void updateStoreNotice(String storeId, UpdateStoreNoticeDTO data);

    //매장 공지 삭제
    public void deleteStoreNotice(String storeId, DeleteStoreNoticeDTO data);

    //매장 공지 리스트
    public List<StoreNotice> selectStoreNotice(String storeId);

    //매장 공지 읽기
    public StoreNotice readStoreNotice(int noticeNum);
}
