package net.softsociety.bacs.storeNotice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.softsociety.bacs.store.entity.Store;
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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "STORE_NOTICE_NOTICEID_SEQ")
    @Column(name = "NOTICE_NO")
    private Long id;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "store_NO")
    private Store store;

    public void update(
            String noticeTitle,
            String noticeContents
    ) {
        this.noticeTitle = noticeTitle;
        this.noticeContents = noticeContents;
    }
}
