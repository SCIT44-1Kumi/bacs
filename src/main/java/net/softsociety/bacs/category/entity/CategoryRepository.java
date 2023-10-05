package net.softsociety.bacs.category.entity;

import net.softsociety.bacs.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryNameAndStore(String categoryName, Store store_id);

    Optional<Category> findByIdAndStore(Long id, Store store);

    void delete(Category category);

    List<Category> findAllByStore_id(Long store_id);
    Optional<List<Category>> findAllByStoreOrderById(Store store);
}
