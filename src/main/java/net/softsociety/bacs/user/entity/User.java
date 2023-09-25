package net.softsociety.bacs.user.entity;


import lombok.*;
import net.softsociety.bacs.notice.entity.Notice;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.storeNotice.entity.StoreNotice;
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

    @Column(updatable = false, unique = true, name = "userId")
    private String userId;

    @Column(nullable = false, name = "userPw")
    private String userPw;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "rolename")
    private Role rolename;

    @Column(nullable = false, name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Store> stores = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Notice> notices = new ArrayList<>();

    @CreatedDate
    @Column(nullable = false, name = "createdAt")
    private LocalDateTime createdAt;

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
