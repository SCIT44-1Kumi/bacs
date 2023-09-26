package net.softsociety.bacs.admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.admin.dto.BlockStoreDTO;
import net.softsociety.bacs.admin.dto.DeleteStoreDTO;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import net.softsociety.bacs.user.entity.User;
import net.softsociety.bacs.user.entity.UserRepository;
import net.softsociety.bacs.user.exception.AuthenticationErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Override
    public List<Store> getStoreList() {
        return storeRepository.findAll();
    }

    @Override
    public void deleteStore(DeleteStoreDTO dto) {
        Store store = storeRepository.findByStoreId(dto.storeId())
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        storeRepository.delete(store);
    }

    @Override
    public void blockStore(BlockStoreDTO dto) {
        User user = userRepository.findByUserId(dto.userId())
                .orElseThrow(AuthenticationErrorCode.USER_NULL::defaultException);

        user.changeEnabled(false);
    }

    @Override
    public void rebockStore(BlockStoreDTO dto) {
        User user = userRepository.findByUserId(dto.userId())
                .orElseThrow(AuthenticationErrorCode.USER_NULL::defaultException);

        user.changeEnabled(true);
    }
}
