package net.softsociety.bacs.kiosk.entity;

import lombok.*;
import net.softsociety.bacs.store.entity.Store;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "BACS_KIOSK")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Kiosk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "kioskNum")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_KIOSK_SEQ")
    private int kioskNum;

    @Column(nullable = false, name = "storeCode")
    private String storeCode;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
