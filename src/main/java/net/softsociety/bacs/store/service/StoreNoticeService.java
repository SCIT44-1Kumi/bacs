package net.softsociety.bacs.store.service;

import net.softsociety.bacs.domain.dto.storeNotice.CreateStoreNoticeDTO;
import net.softsociety.bacs.domain.dto.storeNotice.DeleteStoreNoticeDTO;
import net.softsociety.bacs.domain.dto.storeNotice.UpdateStoreNoticeDTO;
import net.softsociety.bacs.domain.vo.StoreNotice;

import java.util.ArrayList;

public interface StoreNoticeService {

    //매장 공지 작성
    public boolean createStoreNotice(CreateStoreNoticeDTO data);

    //매장 공지 수정
    public int updateStoreNotice(UpdateStoreNoticeDTO data);

    //매장 공지 삭제
    public int deleteStoreNotice(DeleteStoreNoticeDTO data);

    //매장 공지 리스트
    public ArrayList<StoreNotice> selectStoreNotice(String storeId);

    //매장 공지 읽기
    public ArrayList<StoreNotice> readStoreNotice(int noticeNum);
}
