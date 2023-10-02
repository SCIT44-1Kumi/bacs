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

    @Column(nullable = false)
    private int storeCode;

    @ManyToOne
    @JoinColumn(name = "store_no")
    private Store store;

    public void update(
            int storeCode
    ) {
        this.storeCode = storeCode;
    }
}
