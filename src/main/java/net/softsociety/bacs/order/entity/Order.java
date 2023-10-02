package net.softsociety.bacs.order.entity;

import lombok.*;
import lombok.Builder.Default;
import lombok.ToString.Exclude;
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
@ToString
public class Order {

    @Id
    @Column(name = "order_no")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDER_NO_SEQ")
    private Long id;

    @Column(nullable = false)
    private int totalPrice;

    @Column(updatable = false, nullable = false)
    private boolean toGo;

    @Builder.Default
    @Column(nullable = false)
    private boolean cancelled = false;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "store_no")
    private Store store;

    @Default
    @OneToMany(mappedBy = "menu")
    @Exclude
    private List<OrderRecipe> orderRecipes = new ArrayList<>();

    public void setOrderRecipes(List<OrderRecipe> orderRecipes) {
        this.orderRecipes = orderRecipes;
    }

    public void addOrderRecipes(OrderRecipe orderRecipe) {
        this.orderRecipes.add(orderRecipe);
    }
    public void removeOrderRecipes(OrderRecipe orderRecipe) {
        this.orderRecipes.remove(orderRecipe);
    }

    public void setTotalPrice(List<OrderRecipe> orderRecipes) {
        // stream() 사용
        // List.stream() : 스트림객체
        //  .mapToInt(클래스::클래스 내부 함수) : IntStream 객체 상태, 리스트로부터 int값을 반환해 새로운 List<int>를 반환
        //  .sum() : 위 IntStream으로부터 받은 int들을 전부 더한 값을 return
        this.totalPrice = orderRecipes.stream()
                .mapToInt(orderRecipe -> orderRecipe.getRecipePrice())
                .sum();
    }
}
