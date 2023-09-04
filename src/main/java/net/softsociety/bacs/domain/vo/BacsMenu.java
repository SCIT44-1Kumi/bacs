package net.softsociety.bacs.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsMenu {

  private int menuNum;
  private String menuName;
  private String menuPrice;
  private String menuImg;
  private String menuDesc;
  private String storeId;
  private String categoryNum;


}
