package net.softsociety.bacs.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.domain.vo.BacsStore;
import net.softsociety.bacs.store.dto.CreateStoreDTO;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store createStore(CreateStoreDTO createStoreDTO) {

        // 존재하는 매장인지 확인
        if(storeRepository.findByStoreId(createStoreDTO.storeId()).isPresent()){
            throw StoreErrorCode.STORE_CONFLICT.defaultException();
        }

        // 매장 객체 생성
        Store newStore = Store.builder()
                .storeId(createStoreDTO.storeId())
                .storeName(createStoreDTO.storeName())
                .storePhone(createStoreDTO.storePhone())
                .storeAddress(createStoreDTO.storeAddress())
                .crNum(createStoreDTO.crNum())
                .build();
        // db에 저장
        return storeRepository.save(newStore);
    }
}