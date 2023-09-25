package net.softsociety.bacs.menu.dto;

import lombok.Builder;
import net.softsociety.bacs.category.entity.Category;

import javax.validation.constraints.NotBlank;

@Builder
public record GetMenusDTO(
        @NotBlank
        Category category
) {
}
