package net.softsociety.bacs.category.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
public record DeleteCategoryDTO(
        @NotBlank
        int categoryNum
) {}
