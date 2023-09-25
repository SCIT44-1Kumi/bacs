package net.softsociety.bacs.store.entity;


import lombok.*;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.kiosk.entity.Kiosk;
import net.softsociety.bacs.menu.entity.Menu;
import net.softsociety.bacs.storeNotice.entity.StoreNotice;
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

    @Column(updatable = false, unique = true, name = "storeId")
    private String storeId;

    @Column(nullable = false, name = "storeName")
    private String storeName;

    @Column(nullable = false, name = "storeAddress")
    private String storeAddress;

    @Column(nullable = false, name = "crNum")
    private String crNum;

    @Column(nullable = false, name = "storePhone")
    private String storePhone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "store")
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<StoreNotice> storeNotices = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Kiosk> kiosks = new ArrayList<>();


    @CreatedDate
    @Column(nullable = false, name = "createdAt")
    private LocalDateTime createdAt;

    public void addStoreNotices(StoreNotice storeNotice) {
        this.storeNotices.add(storeNotice);
    }

    public void removeStoreNotices(StoreNotice storeNotice) {
        this.storeNotices.remove(storeNotice);
    }

    public void addKiosk(Kiosk kiosk) {
        this.kiosks.add(kiosk);
    }
    public void removeKiosk(Kiosk kiosk) {
        this.kiosks.remove(kiosk);
    }

    public void update(String storeName, String storeAddress, String crNum, String storePhone) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.crNum = crNum;
        this.storePhone = storePhone;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }
}