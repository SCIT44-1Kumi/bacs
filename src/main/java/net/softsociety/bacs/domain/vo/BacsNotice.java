package net.softsociety.bacs.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacsNotice {

  private String noticeNum;
  private String noticeTitle;
  private String noticeContents;
  private String noticeViews;
  private String createdAt;
  private String userId;



}
