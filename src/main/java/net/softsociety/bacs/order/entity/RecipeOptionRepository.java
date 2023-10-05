package net.softsociety.bacs.order.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeOptionRepository extends JpaRepository<RecipeOption, Long> {

    List<RecipeOption> findAllByOrderRecipe(OrderRecipe orderRecipe);
}
