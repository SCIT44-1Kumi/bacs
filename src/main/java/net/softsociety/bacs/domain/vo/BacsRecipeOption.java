package net.softsociety.bacs.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsRecipeOption {

  private String roNum;
  private String roAmount;
  private String recipeNum;
  private String optionNum;



}
