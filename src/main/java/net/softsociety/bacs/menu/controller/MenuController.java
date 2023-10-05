package net.softsociety.bacs.menu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.menu.dto.GetMenusDTO;
import net.softsociety.bacs.menu.dto.response.MenuResponseDTO;
import net.softsociety.bacs.menu.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("{storeId}/menu")
@Slf4j
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("getMenus")
    public List<MenuResponseDTO> getMenuList(@RequestParam(name = "categoryNo") @Valid long categoryNo) {
        return menuService.getMenuList(categoryNo);
    }
}
