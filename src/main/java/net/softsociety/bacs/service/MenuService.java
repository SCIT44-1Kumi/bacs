package net.softsociety.bacs.service;

import net.softsociety.bacs.domain.BacsMenu;
import net.softsociety.bacs.domain.BacsMenuOption;

import java.util.ArrayList;

public interface MenuService {

    boolean createMenu(BacsMenu menu, ArrayList<BacsMenuOption> options);
}
