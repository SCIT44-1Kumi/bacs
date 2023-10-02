package net.softsociety.bacs.menu.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Builder
public record InsertMenuDTO(
        @NotNull
        long categoryNo,
        @NotBlank
        String menuName,
        @NotNull
        int menuPrice,

        String menuImg,

        String menuDesc,
        @NotNull
        ArrayList<InsertMenuOptionDTO> options
) {}


