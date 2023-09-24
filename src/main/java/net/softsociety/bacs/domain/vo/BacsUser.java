package net.softsociety.bacs.domain.vo;


import lombok.*;
import net.softsociety.bacs.user.Role;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "BACS_USER")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class BacsUser{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(updatable = false, nullable = false)
  private String userId;

  @Column(nullable = false)
  private String userPw;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String phone;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role rolename;

  @Column(nullable = false)
  private boolean enabled;

}
