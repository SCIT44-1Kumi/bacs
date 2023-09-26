package net.softsociety.bacs.menu.entity;


import lombok.*;
import net.softsociety.bacs.order.entity.RecipeOption;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BACS_MENU_OPTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class MenuOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "OPTIONID_SEQ")
    @Column(name = "OPTIONID")
    private Long id;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_MENU_OPTION_SEQ")
    private int optionNum;

    @Column(nullable = false)
    private String optionName;

    @Column(nullable = false)
    private String optionValue;

    @Column(nullable = false)
    private long optionPrice;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "option")
    private List<RecipeOption> recipeOptions;

    public void addRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.add(recipeOption);
    }
    public void removeRecipeOption(RecipeOption recipeOption) {
        this.recipeOptions.remove(recipeOption);
    }

    public void update(
            String optionName,
            String optionValue,
            long optionPrice,
            Menu menu_id
    ) {
        this.optionName = optionName;
        this.optionValue = optionValue;
        this.optionPrice = optionPrice;
        this.menu = menu_id;
    }
}
