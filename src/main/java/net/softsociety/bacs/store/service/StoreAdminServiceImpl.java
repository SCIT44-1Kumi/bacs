package net.softsociety.bacs.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.order.entity.OrderRepository;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class StoreAdminServiceImpl implements StoreAdminService {


    private final OrderRepository orderRepository;
    private final StoreRepository storeRepository;


    @Override
    public Optional<Long> saleToday(String storeId) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        return orderRepository.saleToday(store.getStoreId());
    }

    @Override
    public Optional<Long> salesWeek(String storeId) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        return orderRepository.salesWeek(store.getStoreId());
    }
}
