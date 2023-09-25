package net.softsociety.bacs.menu.entity;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "BACS_MENU_OPTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class MenuOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "optionNum")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BACS_MENU_OPTION_SEQ")
    private int optionNum;

    @Column(nullable = false, name = "optionName")
    private String optionName;

    @Column(nullable = false, name = "optionValue")
    private String optionValue;

    @Column(nullable = false, name = "optionPrice")
    private long optionPrice;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public void update(
            String optionName,
            String optionValue,
            long optionPrice,
            Menu menu_id
    ) {
        this.optionName = optionName;
        this.optionValue = optionValue;
        this.optionPrice = optionPrice;
        this.menu = menu_id;
    }
}
