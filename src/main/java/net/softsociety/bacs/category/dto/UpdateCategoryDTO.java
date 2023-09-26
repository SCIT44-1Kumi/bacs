package net.softsociety.bacs.category.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
public record UpdateCategoryDTO(
        @NotBlank
        int categoryNum,
        @NotBlank
        String categoryName
) {}