package net.softsociety.bacs.storeNotice.entity;

import lombok.*;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.user.entity.User;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STORE_NOTICE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class StoreNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "STORE_NOTICE_NOTICE_NO_SEQ")
    @Column(name = "NOTICE_NO")
    private Long id;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_NOTICE_SEQ")
    private int noticeNum;

    @Column(nullable = false)
    private String noticeTitle;

    @Column(nullable = false)
    private String noticeContents;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int noticeViews;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "store_no")
    private Store store;

    public void update(
            String noticeTitle,
            String noticeContents
    ) {
        this.noticeTitle = noticeTitle;
        this.noticeContents = noticeContents;
    }
}
