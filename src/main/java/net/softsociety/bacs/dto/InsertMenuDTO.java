package net.softsociety.bacs.dto;

import lombok.Data;
import net.softsociety.bacs.domain.BacsMenu;
import net.softsociety.bacs.domain.BacsMenuOption;

import java.util.ArrayList;

@Data
public class InsertMenuDTO {
    private BacsMenu menu;
    private ArrayList<BacsMenuOption> options;
}


