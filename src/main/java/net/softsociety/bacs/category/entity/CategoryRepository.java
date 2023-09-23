package net.softsociety.bacs.category.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryNameAndStoreId(String categoryName, String storeId);
}
