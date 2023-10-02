package net.softsociety.bacs.category.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record DeleteCategoryDTO(
        @NotBlank
        long categoryNo
) {}
