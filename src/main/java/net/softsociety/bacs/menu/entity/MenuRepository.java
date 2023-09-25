package net.softsociety.bacs.menu.entity;

import net.softsociety.bacs.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findByMenuNum(int menuNum);
    List<Menu> findByCategory_id(Category category);
}
