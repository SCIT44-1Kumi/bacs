package net.softsociety.bacs.order.entity;

import lombok.*;
import net.softsociety.bacs.store.entity.Store;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BACS_ORDER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @Column(name = "order_no")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDER_NO_SEQ")
    private Long id;

    @Column(updatable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_ORDER_SEQ")
    private String orderNum;

    @Column(updatable = false,nullable = false)
    @ColumnDefault("0")
    private long totalPrice;

    @Column(updatable = false, nullable = false)
    @ColumnDefault("false")
    private boolean toGo;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "store_no")
    private Store store;

    @OneToMany(mappedBy = "menu")
    private List<OrderRecipe> orderRecipes = new ArrayList<>();

    public void addOrderRecipes(OrderRecipe orderRecipe) {
        this.orderRecipes.add(orderRecipe);
    }
    public void removeOrderRecipes(OrderRecipe orderRecipe) {
        this.orderRecipes.remove(orderRecipe);
    }
}
