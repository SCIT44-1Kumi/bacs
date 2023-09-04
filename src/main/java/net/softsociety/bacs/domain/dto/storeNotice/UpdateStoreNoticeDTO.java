package net.softsociety.bacs.domain.dto.storeNotice;

import lombok.Data;

@Data
public class UpdateStoreNoticeDTO
{
    private String noticeNum;
    private String noticeTitle;
    private String noticeContents;
    private String storeId;
}
