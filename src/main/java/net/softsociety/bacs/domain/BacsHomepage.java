package net.softsociety.bacs.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsHomepage {

  private String homepageNum;
  private String templateNum;
  private String bannerImg;
  private String storeIntro1;
  private String storeIntro2;
  private String storeIntro3;
  private String operatingHours;
  private String storeId;



}
