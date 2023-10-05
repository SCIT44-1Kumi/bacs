package net.softsociety.bacs.category.dto.response;

import lombok.Builder;

@Builder
public record CategoryResponseDTO(
        Long id,
        String categoryName
) {
}
