package net.softsociety.bacs.notice.entity;

import lombok.*;
import net.softsociety.bacs.user.entity.User;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "BACS_NOTICE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Notice {

    @Id
    @Column(name = "NOTICE_NO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NOTICEID_SEQ")
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
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    public void update(
        String noticeTitle,
        String noticeContents
    ) {
        this.noticeTitle = noticeTitle;
        this.noticeContents = noticeContents;
    }


}
