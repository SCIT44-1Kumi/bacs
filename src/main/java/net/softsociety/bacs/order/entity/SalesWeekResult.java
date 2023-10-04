package net.softsociety.bacs.order.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SalesWeekResult {
    private LocalDate orderDate;
    private Long dailyTotalPrice;
}
