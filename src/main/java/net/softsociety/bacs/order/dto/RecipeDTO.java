package net.softsociety.bacs.order.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public record RecipeDTO(
        @NotNull
        long menu_no,

        @NotNull
        int menuAmount,

        List<RecipeOptionDTO> recipeOptionDTOList
) {
}
