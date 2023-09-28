package net.softsociety.bacs.menu.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Builder
public record InsertMenuDTO(
        @NotBlank
        int categoryNum,
        @NotBlank
        String menuName,
        @NotBlank
        int menuPrice,

        String menuImg,

        String menuDesc,
        @NotBlank
        ArrayList<InsertMenuOptionDTO> options
) {}


