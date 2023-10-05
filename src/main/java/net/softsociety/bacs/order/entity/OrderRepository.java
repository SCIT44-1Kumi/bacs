package net.softsociety.bacs.order.entity;

import net.softsociety.bacs.store.projection.SalesWeekResultProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //당일 매출 조회
    @Query(value = "SELECT SUM(TOTAL_PRICE) AS daily_total_price FROM BACS_ORDER WHERE TRUNC(ORDER_DATE) = TRUNC(SYSDATE) and STORE_NO = :id", nativeQuery = true)
    Optional<Long> saleToday(Long id);


    @Query(value = "SELECT TRUNC(ORDER_DATE) AS order_date, CAST(SUM(TOTAL_PRICE) AS NUMBER) AS daily_total_price FROM BACS_ORDER WHERE ORDER_DATE BETWEEN TRUNC(SYSDATE) -7 AND TRUNC(SYSDATE) -1 and STORE_NO = :id GROUP BY TRUNC(ORDER_DATE) ORDER BY TRUNC(ORDER_DATE)", nativeQuery = true)
    List<SalesWeekResultProjection> salesWeek(Long id);


}
