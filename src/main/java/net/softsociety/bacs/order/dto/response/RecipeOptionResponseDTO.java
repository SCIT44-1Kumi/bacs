package net.softsociety.bacs.order.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import net.softsociety.bacs.menu.entity.menuOption.MenuOption;

@Builder
public record RecipeOptionResponseDTO(
        Long id,
        int roAmount,
        MenuOption option
) {
}
