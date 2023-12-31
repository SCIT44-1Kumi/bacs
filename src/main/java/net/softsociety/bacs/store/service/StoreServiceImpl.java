package net.softsociety.bacs.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.store.dto.request.CreateStoreDTO;
import net.softsociety.bacs.store.dto.response.StoreResponseDTO;
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

        storeRepository.save(newStore);
        user.addStore(newStore);
    }

    // 매장 조회
    @Override
    public StoreResponseDTO getStore(String storeId) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);


        log.debug("--------store: {}", store);
        return StoreResponseDTO.builder()
                .storeNo(store.getId())
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .storePhone(store.getStorePhone())
                .storeAddress(store.getStoreAddress())
                .crNum(store.getCrNum())
                .createdAt(store.getCreatedAt())
                .build();
    }

    @Override
    public StoreResponseDTO getStoreByUser(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(AuthenticationErrorCode.USER_NULL::defaultException);

        Store store = storeRepository.findByUser(user)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        return StoreResponseDTO.builder()
                .storeNo(store.getId())
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .storePhone(store.getStorePhone())
                .storeAddress(store.getStoreAddress())
                .crNum(store.getCrNum())
                .createdAt(store.getCreatedAt())
                .build();
    }
    // TODO: 매장 삭제
    // TODO: 매장 업데이트
}
