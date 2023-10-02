package net.softsociety.bacs.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.store.dto.CreateStoreDTO;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import net.softsociety.bacs.user.entity.User;
import net.softsociety.bacs.user.entity.UserRepository;
import net.softsociety.bacs.user.exception.AuthenticationErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    public void createStore(CreateStoreDTO createStoreDTO) {

        // 존재하는 매장인지 확인
        if(storeRepository.findByStoreId(createStoreDTO.storeId()).isPresent()){
            throw StoreErrorCode.STORE_CONFLICT.defaultException();
        }

        User user = userRepository.findByUserId(createStoreDTO.userId())
                .orElseThrow(AuthenticationErrorCode.USER_NULL::defaultException);


        // 매장 객체 생성
        Store newStore = Store.builder()
                .storeId(createStoreDTO.storeId())
                .storeName(createStoreDTO.storeName())
                .storePhone(createStoreDTO.storePhone())
                .storeAddress(createStoreDTO.storeAddress())
                .crNum(createStoreDTO.crNum())
                .user(user)
                .build();
        // db에 저장

        user.addStore(newStore);
        storeRepository.save(newStore);
    }

    // TODO: 매장 삭제
    // TODO: 매장 조회
    // TODO: 매장 업데이트
}
