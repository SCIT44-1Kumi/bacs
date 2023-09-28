package net.softsociety.bacs.menu.dto;

import lombok.Builder;




import net.softsociety.bacs.menu.entity.Menu;
import net.softsociety.bacs.menu.entity.MenuOption;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Builder
public record InsertMenuDTO(
        @NotBlank
        int categoryNum,
        @NotBlank
        Menu menu,
        @NotBlank
        ArrayList<MenuOption> options
) {}


