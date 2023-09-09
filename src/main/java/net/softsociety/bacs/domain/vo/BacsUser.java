package net.softsociety.bacs.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BacsUser implements UserDetails {

  @Id
  @Column(updatable = false, unique = true, nullable = false)
  private String userId;

  @Column(nullable = true)
  private String userPw;
  private String email;
  private String phone;

  @ElementCollection(fetch = FetchType.EAGER)
  @Builder.Default
  private List<String> rolename = new ArrayList<>();
  private String enabled;
  private String createdAt;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.rolename.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }
  @Override
  public String getPassword() {
    return this.userPw;
  }

  @Override
  public String getUsername() {
    return this.userId;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }


  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }


  @Override
  public boolean isEnabled() {
    return true;
  }
}
