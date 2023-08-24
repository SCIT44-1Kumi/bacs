package net.softsociety.bacs.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsUser {

  private String userId;
  private String userPw;
  private String email;
  private String phone;
  private String rolename;
  private String enabled;
  private String createdAt;



}
