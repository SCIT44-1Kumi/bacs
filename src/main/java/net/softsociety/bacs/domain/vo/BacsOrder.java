package net.softsociety.bacs.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsOrder {

  private String orderNum;
  private String orderDate;
  private String totalPrice;
  private String toGo;
  private String storeId;


}
