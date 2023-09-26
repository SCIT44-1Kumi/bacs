package net.softsociety.bacs.domain.vo;


import lombok.*;
import net.softsociety.bacs.user.entity.Role;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsUser {
  private String userId;
  private String userPw;
  private String email;
  private String phone;
  private Role rolename;
  private boolean enabled;
}
