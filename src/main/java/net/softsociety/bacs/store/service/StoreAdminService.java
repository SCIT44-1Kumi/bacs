package net.softsociety.bacs.store.service;


import net.softsociety.bacs.order.entity.SalesWeekResult;
import net.softsociety.bacs.store.dto.SaleTodayDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface StoreAdminService {

    Optional<Long> saleToday(SaleTodayDTO dto);


    Optional<SalesWeekResult> salesWeek(SaleTodayDTO dto);
}
