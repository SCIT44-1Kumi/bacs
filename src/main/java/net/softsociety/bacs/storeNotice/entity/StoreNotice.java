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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "noticeNum")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_NOTICE_SEQ")
    private int noticeNum;

    @Column(nullable = false, name = "noticeTitle")
    private String noticeTitle;

    @Column(nullable = false, name = "noticeContents")
    private String noticeContents;

    @Column(nullable = false, name = "noticeViews")
    @ColumnDefault("0")
    private int noticeViews;

    @CreatedDate
    @Column(nullable = false, name = "createdAt")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public void update(
            String noticeTitle,
            String noticeContents
    ) {
        this.noticeTitle = noticeTitle;
        this.noticeContents = noticeContents;
    }
}
