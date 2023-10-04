package net.softsociety.bacs.store.service;


import net.softsociety.bacs.store.dto.SaleTodayDTO;

import java.util.Optional;

public interface StoreAdminService {

    Optional<Long> saleToday(SaleTodayDTO dto);


    Optional<Long> salesWeek(SaleTodayDTO dto);
}
