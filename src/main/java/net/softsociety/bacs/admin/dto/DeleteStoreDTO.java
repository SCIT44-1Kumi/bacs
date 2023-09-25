package net.softsociety.bacs.admin.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
public record DeleteStoreDTO(
        @NotBlank
        String storeId
) {}
