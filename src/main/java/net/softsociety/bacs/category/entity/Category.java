package net.softsociety.bacs.category.entity;

import lombok.*;
import net.softsociety.bacs.menu.entity.Menu;
import net.softsociety.bacs.store.entity.Store;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CATEGORYID_SEQ")
    @Column(name = "CATEGORYID")
    private Long id;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_CATEGORY_SEQ")
    private int categoryNum;

    @Column(nullable = false)
    private String categoryName;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "storeid")
    private Store store;

    @OneToMany(mappedBy = "category")
    private List<Menu> menus = new ArrayList<>();

    public void update(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addMenu(Menu menu){
        this.menus.add(menu);
    }

}
