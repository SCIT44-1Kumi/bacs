package net.softsociety.bacs.kiosk.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record DeleteKioskDTO(
        @NotBlank
        int kioskNum
) {
}