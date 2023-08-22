package net.softsociety.bacs.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsOrderRecipe {

  private String recipeNum;
  private String menuAmount;
  private String recipePrice;
  private String menuNum;
  private String orderNum;



}
