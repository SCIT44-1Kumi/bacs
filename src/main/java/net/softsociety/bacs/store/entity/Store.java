package net.softsociety.bacs.store.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.Builder.Default;
import lombok.ToString.Exclude;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.kiosk.entity.Kiosk;
import net.softsociety.bacs.order.entity.Order;
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
@ToString
public class Store {
    @Id
    @Column(name = "store_no")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "STORE_NO_SEQ")
    private Long id;

    @Column(updatable = false, unique = true)
    private String storeId;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String storeAddress;

    @Column(nullable = false)
    private String crNum;

    @Column(nullable = false)
    private String storePhone;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @Default
    @OneToMany(mappedBy = "store")
    @Exclude
    private List<Category> categories = new ArrayList<>();

    @Default
    @OneToMany(mappedBy = "store")
    @Exclude
    private List<StoreNotice> storeNotices = new ArrayList<>();

    @Default
    @OneToMany(mappedBy = "store")
    @Exclude
    private List<Kiosk> kiosks = new ArrayList<>();

    @Default
    @OneToMany(mappedBy = "store")
    @Exclude
    private List<Order> orders = new ArrayList<>();

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setKiosks(List<Kiosk> kiosks) {
        this.kiosks = kiosks;
    }

    public void setStoreNotices(List<StoreNotice> storeNotices) {
        this.storeNotices = storeNotices;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

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

    public void addOrder(Order order) {
        this.orders.add(order);
    }
    public void removeOrder(Order order) {
        this.orders.remove(order);
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