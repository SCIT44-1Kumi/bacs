package net.softsociety.bacs.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsKiosk {

  private String kioskNum;
  private String storeCode;
  private String easyMode;
  private String voiceMode;
  private String storeId;



}
