package net.softsociety.bacs.menu.dto;

import lombok.Builder;
import net.softsociety.bacs.category.entity.Category;

import javax.validation.constraints.NotBlank;

@Builder
public record UpdateMenuDTO(
        @NotBlank
        int menuNum,
        @NotBlank
        String menuName,
        @NotBlank
        int menuPrice,
        @NotBlank
        String menuImg,
        @NotBlank
        String menuDesc,
        @NotBlank
        Category category_id
) {
}
