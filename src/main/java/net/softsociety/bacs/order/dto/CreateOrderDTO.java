package net.softsociety.bacs.order.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
public record CreateOrderDTO(
    @NotNull
    boolean toGo,

    @NotNull
    List<RecipeDTO> recipeDTOList
) {
}
