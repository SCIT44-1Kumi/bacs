package net.softsociety.bacs.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.order.entity.OrderRepository;
import net.softsociety.bacs.store.dto.SaleTodayDTO;
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
    public Optional<Long> saleToday(SaleTodayDTO dto) {
        Store store = storeRepository.findByStoreId(dto.storeId())
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        return orderRepository.saleToday(store.getId());
    }

    @Override
    public Optional<Long> salesWeek(SaleTodayDTO dto) {
        Store store = storeRepository.findByStoreId(dto.storeId())
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        return orderRepository.salesWeek(store.getId());
    }
}
