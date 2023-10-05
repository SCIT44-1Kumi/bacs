package net.softsociety.bacs.menu.dto;

import lombok.Builder;

import javax.validation.constraints.NotNull;

@Builder
public record GetMenusDTO(
        @NotNull
        long categoryNo
) {
}
