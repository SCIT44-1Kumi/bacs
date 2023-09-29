package net.softsociety.bacs.kiosk.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record UpdateKioskDTO(
        @NotBlank
        long kioskNo,
        @NotBlank
        String storeCode
) {
}
