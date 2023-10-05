package net.softsociety.bacs.menu.dto.response;

import lombok.Builder;

@Builder
public record MenuOptionResponseDTO(
        Long id,
        String optionName,
        String optionValue,
        int optionPrice
) {
}
