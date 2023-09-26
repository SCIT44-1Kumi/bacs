package net.softsociety.bacs.menu.entity;

import lombok.*;
import net.softsociety.bacs.category.entity.Category;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_MENU_SEQ")
    @Column(unique = true, name = "menuNum")
    private int menuNum;

    @Column(nullable = false, name = "menuName")
    private String menuName;

    @Column(nullable = false, name = "menuPrice")
    private long menuPrice;

    @Column(name = "menuImg")
    @ColumnDefault("")
    private String menuImg;

    @Column(name = "menuDesc")
    @ColumnDefault("")
    private String menuDesc;

    @CreatedDate
    @Column(nullable = false, name = "createdAt")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "menu")
    private List<MenuOption> menuOptions = new ArrayList<>();

    public void addMenuOption(MenuOption menuOption) {
        this.menuOptions.add(menuOption);
    }

    public void removeMenuOption(MenuOption menuOption) {
        this.menuOptions.remove(menuOption);
    }

    public void update(
            String menuName,
            long menuPrice,
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
