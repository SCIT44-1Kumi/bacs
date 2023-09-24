package net.softsociety.bacs.domain.vo;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BACS_ORDER")
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class BacsOrder{

  //bacsorder.builder()
              //.totalprice
  //        .build()


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 이 부분 추가
  private Long orderId;

  @Column(updatable = false, nullable = false)
  private String totalPrice;

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private LocalDateTime orderDate;

  @Column(updatable = false, nullable = false)
  private String toGo;

  @Column(updatable = false, nullable = false)
  private String storeId;


}
