package net.softsociety.bacs.menu.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuOptionRepository extends JpaRepository<MenuOption, Long> {
    Optional<MenuOption> findByOptionNum(int menuNum);
}
