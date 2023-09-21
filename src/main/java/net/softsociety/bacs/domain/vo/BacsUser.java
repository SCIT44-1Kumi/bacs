package net.softsociety.bacs.domain.vo;


import lombok.*;
import net.softsociety.bacs.user.Role;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "BACS_USER")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class BacsUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

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

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private LocalDateTime createdAt;

}
