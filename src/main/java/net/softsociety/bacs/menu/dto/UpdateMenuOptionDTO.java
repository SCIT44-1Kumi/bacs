package net.softsociety.bacs.menu.dto;

import lombok.Builder;
import net.softsociety.bacs.menu.entity.menu.Menu;

import javax.validation.constraints.NotBlank;

@Builder
public record UpdateMenuOptionDTO(
        @NotBlank
        long optionNo,
        @NotBlank
        String optionName,
        @NotBlank
        String optionValue,
        @NotBlank
        int optionPrice,
        @NotBlank
        Menu menu
) {}
