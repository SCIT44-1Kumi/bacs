package net.softsociety.bacs.order.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public record RecipeDTO(
        @NotBlank
        long menu_no,

        @NotBlank
        int menuAmount,

        List<RecipeOptionDTO> recipeOptionDTOList
) {
}
