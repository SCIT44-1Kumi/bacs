package net.softsociety.bacs.store.service;


import net.softsociety.bacs.order.entity.SalesWeekResult;
import net.softsociety.bacs.store.dto.SaleTodayDTO;

import java.util.List;
import java.util.Optional;

public interface StoreAdminService {

    Optional<Long> saleToday(SaleTodayDTO dto);


    List<SalesWeekResult> salesWeek(SaleTodayDTO dto);
}
