package net.softsociety.bacs.menu.entity.menuOption;


import lombok.*;
import lombok.Builder.Default;
import lombok.ToString.Exclude;
import net.softsociety.bacs.menu.entity.menu.Menu;
import net.softsociety.bacs.order.entity.RecipeOption;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BACS_MENU_OPTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@ToString
public class MenuOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "OPTIONID_SEQ")
    @Column(name = "OPTION_NO")
    private Long id;

    @Column(nullable = false)
    private String optionName;

    @Column(nullable = false)
    private String optionValue;

    @Column(nullable = false)
    private int optionPrice;

    @ManyToOne
    @JoinColumn(name = "menu_no")
    private Menu menu;

    @Default
    @OneToMany(mappedBy = "option")
    @Exclude
    private List<RecipeOption> recipeOptions = new ArrayList<>();

    public void setRecipeOptions(List<RecipeOption> recipeOptions) {
        this.recipeOptions = recipeOptions;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void addRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.add(recipeOption);
    }
    public void removeRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.remove(recipeOption);
    }

    public void update(
            String optionName,
            String optionValue,
            int optionPrice,
            Menu menu_id
    ) {
        this.optionName = optionName;
        this.optionValue = optionValue;
        this.optionPrice = optionPrice;
        this.menu = menu_id;
    }
}
