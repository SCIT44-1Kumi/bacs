package net.softsociety.bacs.order.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record RecipeOptionDTO(
        @NotBlank
        long option_no,

        @NotBlank
        int roAmount
) {
}
