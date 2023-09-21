package net.softsociety.bacs.domain.dto.notice;

import lombok.Data;


@Data
public class CreateNoticeDTO {
    String userId;
    String noticeTitle;
    String noticeContents;
}
