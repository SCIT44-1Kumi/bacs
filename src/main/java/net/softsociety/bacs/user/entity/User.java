package net.softsociety.bacs.user.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import net.softsociety.bacs.notice.entity.Notice;
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
    @Column(name = "user_no")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_NO_SEQ")
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

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Store> stores = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Notice> notices = new ArrayList<>();

    // 회원에 매장 추가
    public void addStore(Store store) {
        this.stores.add(store);
    }

    public void removeStore(Store store){
        this.stores.remove(store);
    }

    // 회원에 공지 추가
    public void addNotices(Notice notice) {
        this.notices.add(notice);
    }

    public void removeNotices(Notice notice){
        this.notices.remove(notice);
    }


    public void update(String userPw, String email, String phone) {
        this.userPw = userPw;
        this.email = email;
        this.phone = phone;
    }

    public void changeEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void changeRole(Role rolename) {
        this.rolename = rolename;
    }
}
