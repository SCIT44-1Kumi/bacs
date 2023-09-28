package net.softsociety.bacs.order.dto;

import lombok.Builder;
import net.softsociety.bacs.menu.entity.Menu;
import net.softsociety.bacs.order.entity.OrderRecipe;
import org.aspectj.weaver.ast.Not;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Builder
public record CreateOrderDTO(
    @NotBlank
    boolean toGo,

    @NotBlank
    List<RecipeDTO> recipeDTOList
) {
}
