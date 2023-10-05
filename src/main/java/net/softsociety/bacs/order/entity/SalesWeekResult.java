package net.softsociety.bacs.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SalesWeekResult {
    private LocalDate orderdate;
    private Long dailytotalprice;
}
