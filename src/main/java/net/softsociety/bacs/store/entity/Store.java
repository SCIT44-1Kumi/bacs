package net.softsociety.bacs.store.entity;


import lombok.*;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.user.entity.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BACS_STORE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String storeId;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String storeAddress;

    @Column(nullable = false)
    private String crNum;

    @Column(nullable = false)
    private String storePhone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "store")
    private List<Category> categories = new ArrayList<>();


    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public void addCategory(Category category) {
        this.categories.add(category);
    }
}