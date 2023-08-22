package net.softsociety.bacs.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsMenuOption {

  private String optionNum;
  private String optionName;
  private String optionValue;
  private String optionPrice;
  private String menuNum;



}
