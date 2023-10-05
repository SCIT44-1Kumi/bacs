package net.softsociety.bacs.store.service;


import net.softsociety.bacs.order.entity.SalesWeekResult;
import net.softsociety.bacs.store.dto.SaleTodayDTO;
import net.softsociety.bacs.store.projection.SalesWeekResultProjection;

import java.util.List;
import java.util.Optional;

public interface StoreAdminService {

    Optional<Long> saleToday(SaleTodayDTO dto);


    List<SalesWeekResultProjection> salesWeek(String storeId);

}
