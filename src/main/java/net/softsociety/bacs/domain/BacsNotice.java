package net.softsociety.bacs.domain;


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
  private java.sql.Date createdAt;
  private String userId;



}
