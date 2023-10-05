package net.softsociety.bacs.order.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import net.softsociety.bacs.menu.entity.menu.Menu;

import java.util.List;

@Builder
public record OrderRecipeResponseDTO(

        Long id,

        int menuAmount,

        int recipePrice,

        Menu menu,

        List<RecipeOptionResponseDTO> recipeOptions

) {
}
