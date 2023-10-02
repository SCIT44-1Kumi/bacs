package net.softsociety.bacs.category.entity;

import lombok.*;
import net.softsociety.bacs.menu.entity.menu.Menu;
import net.softsociety.bacs.store.entity.Store;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BACS_CATEGORY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Category {

    @Id
    @Column(name = "CATEGORY_NO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CATEGORYID_SEQ")
    private Long id;

    @Column(nullable = false)
    private String categoryName;

    @ManyToOne()
    @JoinColumn(name = "store_no")
    private Store store;

    @Builder.Default
    @OneToMany(mappedBy = "category")
    private List<Menu> menus = new ArrayList<>();

    public void update(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addMenu(Menu menu){
        this.menus.add(menu);
    }

}
