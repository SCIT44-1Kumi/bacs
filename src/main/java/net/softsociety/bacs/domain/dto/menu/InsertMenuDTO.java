package net.softsociety.bacs.domain.dto.menu;

import lombok.Data;
import net.softsociety.bacs.domain.vo.BacsCategory;
import net.softsociety.bacs.domain.vo.BacsMenu;
import net.softsociety.bacs.domain.vo.BacsMenuOption;

import java.util.ArrayList;

@Data
public class InsertMenuDTO {
    private BacsCategory category;
    private BacsMenu menu;
    private ArrayList<BacsMenuOption> options;
}


