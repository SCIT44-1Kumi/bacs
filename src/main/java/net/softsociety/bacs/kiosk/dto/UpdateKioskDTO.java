package net.softsociety.bacs.kiosk.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
public record UpdateKioskDTO(
        @NotBlank
        long kioskNo,
        @NotNull
        int storeCode
) {
}
