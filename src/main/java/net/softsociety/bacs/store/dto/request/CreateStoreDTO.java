package net.softsociety.bacs.store.dto.request;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record CreateStoreDTO(
        @NotBlank
        String userId,
        @NotBlank
        String storeId,
        @NotBlank
        String storeName,
        @NotBlank
        String storeAddress,
        @NotBlank
        String storePhone,
        @NotBlank
        String crNum
) {}