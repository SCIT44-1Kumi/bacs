package net.softsociety.bacs.dao;

import net.softsociety.bacs.domain.dto.storeNotice.CreateStoreNoticeDTO;
import net.softsociety.bacs.domain.dto.storeNotice.DeleteStoreNoticeDTO;
import net.softsociety.bacs.domain.dto.storeNotice.UpdateStoreNoticeDTO;
import net.softsociety.bacs.domain.vo.StoreNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface StoreNoticeDAO {

    //매장 공지 생성
    boolean createStoreNotice(CreateStoreNoticeDTO data);

    //매장 공지 수정
    public int updateStoreNotice(UpdateStoreNoticeDTO data);

    //매장 공지 삭제
    public int deleteStoreNotice(DeleteStoreNoticeDTO data);

    //매장 공지 리스트 검색
    public ArrayList<StoreNotice> selectStoreNotice(String storeId);

    //매장 공지 읽기
    public ArrayList<StoreNotice> readStoreNotice(int noticeNum);
}
