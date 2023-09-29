package net.softsociety.bacs.order.dto;

import lombok.Builder;

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
