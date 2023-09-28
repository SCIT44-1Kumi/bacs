package net.softsociety.bacs.menu.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record InsertMenuOptionDTO(
        @NotBlank
        String optionName,
        @NotBlank
        String optionValue,
        @NotBlank
        int optionPrice
) {
}
