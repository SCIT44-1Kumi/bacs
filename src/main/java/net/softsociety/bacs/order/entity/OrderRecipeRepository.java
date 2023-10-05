package net.softsociety.bacs.order.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRecipeRepository extends JpaRepository<OrderRecipe, Long> {
    List<OrderRecipe> findAllByOrder(Order order);

}
