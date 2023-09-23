package net.softsociety.bacs.domain.dto.category;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
public record CreateCategoryDTO(
        @NotBlank
        String categoryName,
        @NotBlank
        String storeId
)
{}
