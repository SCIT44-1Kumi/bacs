package net.softsociety.bacs.order.entity;

import lombok.*;
import net.softsociety.bacs.menu.entity.Menu;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BACS_ORDER_RECIPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class OrderRecipe {

    @Id
    @Column(name = "RECIPE_NO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "RECIPEID_SEQ")
    private Long id;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_ORDER_RECIPE_SEQ")
    private long recipeNum;

    @Column(nullable = false)
    @ColumnDefault("1")
    private int menuAmount;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int recipePrice;

    @ManyToOne
    @JoinColumn(name = "menu_no")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "order_no")
    private Order order;

    @OneToMany(mappedBy = "orderRecipe")
    private List<RecipeOption> recipeOptions = new ArrayList<>();

    public void addRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.add(recipeOption);
    }
    public void removeRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.remove(recipeOption);
    }
}
