package net.softsociety.bacs.menu.dto;

import lombok.Builder;
import net.softsociety.bacs.menu.entity.Menu;

import javax.validation.constraints.NotBlank;

@Builder
public record UpdateMenuOptionDTO(
        @NotBlank
        int optionNum,
        @NotBlank
        String optionName,
        @NotBlank
        String optionValue,
        @NotBlank
        int optionPrice,
        @NotBlank
        Menu menu_id
) {}
