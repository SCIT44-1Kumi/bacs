package net.softsociety.bacs.menu.dto;

import lombok.Builder;
import net.softsociety.bacs.category.entity.Category;

import javax.validation.constraints.NotBlank;

@Builder
public record UpdateMenuDTO(
        @NotBlank
        long menuNo,
        @NotBlank
        String menuName,
        @NotBlank
        int menuPrice,
        @NotBlank
        String menuImg,
        @NotBlank
        String menuDesc,
        @NotBlank
        Category category
) {
}
