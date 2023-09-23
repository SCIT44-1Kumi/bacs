package net.softsociety.bacs.user.entity;


import lombok.*;
import net.softsociety.bacs.store.entity.Store;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BACS_USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role rolename;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Store> stores = new ArrayList<>();

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public void addStore(Store store) {
        this.stores.add(store);
    }

}
