package net.softsociety.bacs.menu.dto;

import lombok.Builder;
import lombok.Data;
import net.softsociety.bacs.domain.vo.BacsCategory;
import net.softsociety.bacs.domain.vo.BacsMenu;
import net.softsociety.bacs.domain.vo.BacsMenuOption;
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


