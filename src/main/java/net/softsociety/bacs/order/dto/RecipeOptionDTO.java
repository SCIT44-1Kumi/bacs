package net.softsociety.bacs.order.dto;

import lombok.Builder;
import net.softsociety.bacs.menu.entity.MenuOption;

import javax.validation.constraints.NotBlank;

@Builder
public record RecipeOptionDTO(
        @NotBlank
        long option_no,

        @NotBlank
        int roAmount
) {
}
