package net.softsociety.bacs.store.projection;

import lombok.ToString;

import java.time.LocalDate;


public interface SalesWeekResultProjection {
    LocalDate getOrder_Date();
    Long getDaily_Total_Price();
}
