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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NOTICEID_SEQ")
    @Column(name = "NOTICEID")
    private Long id;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_NOTICE_SEQ")
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
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void update(
        String noticeTitle,
        String noticeContents
    ) {
        this.noticeTitle = noticeTitle;
        this.noticeContents = noticeContents;
    }


}
