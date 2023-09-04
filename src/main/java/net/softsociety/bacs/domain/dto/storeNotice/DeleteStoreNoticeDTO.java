package net.softsociety.bacs.domain.dto.storeNotice;

import lombok.Data;

@Data
public class DeleteStoreNoticeDTO {
    private int noticeNum;
    private String storeId;
}
