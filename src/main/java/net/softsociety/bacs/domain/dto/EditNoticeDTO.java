package net.softsociety.bacs.domain.dto;

import lombok.Data;

@Data
public class EditNoticeDTO {

    int noticeNum;
    String noticeTitle;
    String noticeContents;
    String userId;
}
