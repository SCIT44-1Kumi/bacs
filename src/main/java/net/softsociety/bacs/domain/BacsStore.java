package net.softsociety.bacs.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsStore {

  private String storeId;
  private String storeName;
  private String storeAddress;
  private String crNum;
  private String storePhone;
  private java.sql.Date createdAt;
  private String userId;



}
