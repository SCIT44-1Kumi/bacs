package net.softsociety.bacs.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsCategory {

  private String categoryNum;
  private String categoryName;
  private String storeId;




}
