package net.softsociety.bacs.menu.dto.response;

import lombok.Builder;
import net.softsociety.bacs.menu.entity.menuOption.MenuOption;

import java.util.ArrayList;
import java.util.List;

@Builder
public record MenuResponseDTO(
        Long id,
        String menuName,
        int menuPrice,
        String menuImg,
        String menuDesc,
        List<MenuOptionResponseDTO>menuOptions
) {
}
