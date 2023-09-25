package net.softsociety.bacs.category.entity;

import net.softsociety.bacs.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryNameAndStore(String categoryName, Store store_id);

    Optional<Category> findByCategoryNumAndStore(int categoryNum, Store store_id);

    void delete(Category category);

    List<Category> findByStore_id(Store store_id);
}
