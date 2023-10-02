package net.softsociety.bacs.storeNotice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import net.softsociety.bacs.storeNotice.dto.CreateStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.dto.DeleteStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.dto.UpdateStoreNoticeDTO;
import net.softsociety.bacs.storeNotice.entity.StoreNotice;
import net.softsociety.bacs.storeNotice.entity.StoreNoticeRepository;
import net.softsociety.bacs.storeNotice.exception.StoreNoticeErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class StoreNoticeServiceImpl implements StoreNoticeService
{
    private final StoreRepository storeRepository;
    private final StoreNoticeRepository storeNoticeRepository;

    /**
     * 매장 공지 생성
     *
     * @param storeId
     * @param data
     */
    @Override
    public void createStoreNotice(String storeId, CreateStoreNoticeDTO data) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        StoreNotice storeNotice = StoreNotice.builder()
                .noticeTitle(data.noticeTitle())
                .noticeContents(data.noticeContents())
                .build();
        storeNoticeRepository.save(storeNotice);
        store.addStoreNotices(storeNotice);
    }

    /**
     * 매장 공지 수정
     *
     * @param storeId
     * @param data
     */
    @Override
    public void updateStoreNotice(String storeId, UpdateStoreNoticeDTO data) {
        StoreNotice storeNotice = storeNoticeRepository.findById(data.noticeNo())
                .orElseThrow(StoreNoticeErrorCode.STORE_NOTICE_NULL::defaultException);

        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        storeNotice.update(data.noticeTitle(), data.noticeContents());
    }

    /**
     * 매장 공지 삭제
     *
     * @param storeId
     * @param data
     */
    @Override
    public void deleteStoreNotice(String storeId, DeleteStoreNoticeDTO data) {
        StoreNotice storeNotice = storeNoticeRepository.findById(data.noticeNo())
                .orElseThrow(StoreNoticeErrorCode.STORE_NOTICE_NULL::defaultException);

        Store store = storeRepository.findByStoreId(storeId)
                        .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        storeNoticeRepository.delete(storeNotice);
        store.removeStoreNotices(storeNotice);
    }

    /**
     * 매장 공지 리스트
     *
     * @param storeId
     */
    @Override
    public List<StoreNotice> selectStoreNotice(String storeId) {
        Store store = storeRepository.findByStoreId(storeId)
                        .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        return storeNoticeRepository.findByStore(store);
    }

    /**
     * 매장 공지 읽기
     * @param noticeNo
     */
    @Override
    public StoreNotice readStoreNotice(long noticeNo) {
        return storeNoticeRepository.findById(noticeNo)
                .orElseThrow(StoreNoticeErrorCode.STORE_NOTICE_NULL::defaultException);
    }

}
