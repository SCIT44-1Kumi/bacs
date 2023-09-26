package net.softsociety.bacs.user.entity;

import net.softsociety.bacs.domain.vo.BacsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BacsOrderRepository extends JpaRepository<BacsOrder, Long> {

    @Query(value = "SELECT SUM(TOTAL_PRICE) AS daily_total_price FROM BACS_ORDER WHERE TRUNC(ORDER_DATE) = TRUNC(SYSDATE) and STORE_ID = %:storeId%", nativeQuery = true)
    Optional<Integer> saleToday(@Param("storeId") String storeID);

}
