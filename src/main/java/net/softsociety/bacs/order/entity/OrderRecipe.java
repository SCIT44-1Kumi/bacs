package net.softsociety.bacs.order.entity;

import lombok.*;
import net.softsociety.bacs.menu.entity.menu.Menu;
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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "RECIPE_NO_SEQ")
    private Long id;

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

    @Builder.Default
    @OneToMany(mappedBy = "orderRecipe")
    private List<RecipeOption> recipeOptions = new ArrayList<>();

    public void addRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.add(recipeOption);
    }
    public void removeRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.remove(recipeOption);
    }

    public void setRecipePrice(List<RecipeOption> recipeOptions) {
        // stream() 사용
        // List.stream() : 스트림객체
        //  .mapToInt(클래스::클래스 내부 함수) : IntStream 객체 상태, 리스트로부터 int값을 반환해 새로운 List<int>를 반환
        //  .sum() : 위 IntStream으로부터 받은 int들을 전부 더한 값을 return
        this.recipePrice =  recipeOptions.stream()
                .mapToInt(RecipeOption::getRoPrice)
                .sum() * this.menuAmount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
