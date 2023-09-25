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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "noticeNum")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_NOTICE_SEQ")
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
