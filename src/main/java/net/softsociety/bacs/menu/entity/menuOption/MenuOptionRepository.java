package net.softsociety.bacs.menu.entity.menuOption;

import net.softsociety.bacs.menu.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuOptionRepository extends JpaRepository<MenuOption, Long> {
    Optional<MenuOption> findById(Long id);
    List<MenuOption> findAllByMenu(Menu menu);
}
