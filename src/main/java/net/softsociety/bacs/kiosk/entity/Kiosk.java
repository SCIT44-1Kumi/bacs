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
    @Column(name = "KIOSK_NO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "KIOSK_NO_SEQ")
    private Long id;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_KIOSK_SEQ")
    private int kioskNum;

    @Column(nullable = false)
    private String storeCode;

    @ManyToOne
    @JoinColumn(name = "store_no")
    private Store store;

    public void update(
            String storeCode
    ) {
        this.storeCode = storeCode;
    }
}
