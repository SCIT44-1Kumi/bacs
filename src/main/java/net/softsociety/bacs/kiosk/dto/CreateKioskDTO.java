package net.softsociety.bacs.kiosk.dto;

import lombok.Builder;

import javax.validation.constraints.NotNull;

@Builder
public record CreateKioskDTO(
        @NotNull
        int storeCode
) {
}
