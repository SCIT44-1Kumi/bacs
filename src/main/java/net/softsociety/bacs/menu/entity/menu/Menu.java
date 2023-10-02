package net.softsociety.bacs.menu.entity.menu;

import lombok.*;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.menu.entity.menuOption.MenuOption;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BACS_MENU")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Menu {

    @Id
    @Column(name = "MENUID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "MENUID_SEQ")
    private Long id;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false)
    private int menuPrice;

    @Column
    @Builder.Default
    private String menuImg = "";

    @Column
    @Builder.Default
    private String menuDesc = "";

    @ManyToOne
    @JoinColumn(name = "category_no")
    private Category category;

    @Builder.Default
    @OneToMany(mappedBy = "menu")
    private List<MenuOption> menuOptions = new ArrayList<>();

    public void addMenuOptions(List<MenuOption> options) {
        this.menuOptions = options;
    }

    public void addMenuOption(MenuOption menuOption) {
        this.menuOptions.add(menuOption);
    }

    public void removeMenuOption(MenuOption menuOption) {
        this.menuOptions.remove(menuOption);
    }

    public void update(
            String menuName,
            int menuPrice,
            String menuImg,
            String menuDesc,
            Category category_id
    ) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuImg = menuImg;
        this.menuDesc = menuDesc;
        this.category = category_id;
    }

}
