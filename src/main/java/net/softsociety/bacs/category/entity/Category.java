package net.softsociety.bacs.category.entity;

import lombok.*;
import net.softsociety.bacs.store.entity.Store;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long categoryNum;

    @Column(nullable = false)
    private String categoryName;

    @ManyToOne()
    @JoinColumn(name = "store_id")
    private Store store;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;


}
