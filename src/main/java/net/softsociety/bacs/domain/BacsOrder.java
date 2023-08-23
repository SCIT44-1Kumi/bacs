package net.softsociety.bacs.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsOrder {

  private String orderNum;
  private java.sql.Date orderDate;
  private String totalPrice;
  private String toGo;
  private String storeId;


}
