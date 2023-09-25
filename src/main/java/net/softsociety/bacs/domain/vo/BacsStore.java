package net.softsociety.bacs.domain.vo;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsStore {
  private String storeId;
  private String storeName;
  private String storeAddress;
  private String crNum;
  private String storePhone;
}

