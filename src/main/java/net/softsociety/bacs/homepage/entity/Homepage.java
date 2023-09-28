package net.softsociety.bacs.homepage.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "BACS_HOMEPAGE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Homepage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "HOMEPAGE_NO_SEQ")
    @Column(name = "HOMEPAGE_NO")
    private Long id;
    @Column(unique = true)
    private String homepageNum;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_HOMEPAGE_SEQ")
    private String templateNum;

    @Column(nullable = false)
    @ColumnDefault("")
    private String bannerImg;

    @Column(nullable = false)
    @ColumnDefault("")
    private String storeIntro1;

    @Column(nullable = false)
    @ColumnDefault("")
    private String storeIntro2;

    @Column(nullable = false)
    @ColumnDefault("")
    private String storeIntro3;

    @Column(nullable = false)
    @ColumnDefault("")
    private String operatingHours;

    private String storeId;
}
