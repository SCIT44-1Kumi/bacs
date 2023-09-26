package net.softsociety.bacs.order.entity;

import lombok.*;
import net.softsociety.bacs.menu.entity.MenuOption;
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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ROID_SEQ")
    @Column(name = "ROID")
    private Long id;

    @Column(unique = true)
    private String roNum;

    @Column(nullable = false)
    @ColumnDefault("1")
    private String roAmount;

    @ManyToOne
    @JoinColumn(name = "recipeid")
    private OrderRecipe orderRecipe;

    @ManyToOne
    @JoinColumn(name = "optionid")
    private MenuOption option;
}
