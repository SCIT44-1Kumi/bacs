package net.softsociety.bacs.order.entity;

import lombok.*;
import net.softsociety.bacs.menu.entity.menuOption.MenuOption;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "BACS_RECIPE_OPTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class RecipeOption {

    @Id
    @Column(name = "RO_NO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "RO_NO_SEQ")
    private Long id;

    @Column(nullable = false)
    @ColumnDefault("1")
    private int roAmount;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int roPrice;

    @ManyToOne
    @JoinColumn(name = "option_no")
    private MenuOption option;

    @ManyToOne
    @JoinColumn(name = "recipe_no")
    private OrderRecipe orderRecipe;

    public void setOrderRecipe(OrderRecipe orderRecipe) {
        this.orderRecipe = orderRecipe;
    }
}
