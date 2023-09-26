package net.softsociety.bacs.admin.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record BlockStoreDTO(
    @NotBlank
    String userId
) {}
