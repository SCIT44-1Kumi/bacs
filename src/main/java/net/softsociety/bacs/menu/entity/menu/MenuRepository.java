package net.softsociety.bacs.menu.entity.menu;

import net.softsociety.bacs.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findById(Long id);
    List<Menu> findAllByCategory(Category category);
}
