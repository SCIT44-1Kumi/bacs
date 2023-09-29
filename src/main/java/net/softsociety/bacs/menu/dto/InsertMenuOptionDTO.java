package net.softsociety.bacs.menu.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
public record InsertMenuOptionDTO(
        @NotBlank
        String optionName,
        @NotBlank
        String optionValue,
        @NotNull
        int optionPrice
) {
}
