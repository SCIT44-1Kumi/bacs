package net.softsociety.bacs.store.dto.request;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record GetStoreDTO(
        @NotBlank
        String storeId
) {
}
