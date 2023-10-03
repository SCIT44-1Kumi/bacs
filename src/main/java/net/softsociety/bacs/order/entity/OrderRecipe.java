package net.softsociety.bacs.order.entity;

import lombok.*;
import lombok.Builder.Default;
import lombok.ToString.Exclude;
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
@ToString
public class OrderRecipe {

    @Id
    @Column(name = "RECIPE_NO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "RECIPEID_SEQ")
    private Long id;

    @Column(nullable = false)
    @ColumnDefault("1")
    private int menuAmount;

    @Builder.Default
    @Column(nullable = false)
    private int recipePrice = 0;

    @ManyToOne
    @JoinColumn(name = "menu_no")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "order_no")
    private Order order;

    @Default
    @OneToMany(mappedBy = "orderRecipe")
    @Exclude
    private List<RecipeOption> recipeOptions = new ArrayList<>();

    public void setRecipeOptions(List<RecipeOption> recipeOptions) {
        this.recipeOptions = recipeOptions;
    }

    public void addRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.add(recipeOption);
    }
    public void removeRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.remove(recipeOption);
    }

    public void addRecipeOptions(List<RecipeOption> recipeOptions) {
        this.recipeOptions = recipeOptions;
    }

    public void setRecipePrice(List<RecipeOption> recipeOptions, Menu menu, int menuAmount) {

        // stream() 사용
        // List.stream() : 스트림객체
        //  .mapToInt(클래스::클래스 내부 함수) : IntStream 객체 상태, 리스트로부터 int값을 반환해 새로운 List<int>를 반환
        //  .sum() : 위 IntStream으로부터 받은 int들을 전부 더한 값을 return
        this.recipePrice = (menu.getMenuPrice() + recipeOptions.stream()
                .mapToInt(recipeOption -> recipeOption.getOption().getOptionPrice())
                .sum()) * menuAmount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
