package net.softsociety.bacs.menu.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
public record DeleteMenuDTO(
        @NotBlank
        long menuNo
) {}
