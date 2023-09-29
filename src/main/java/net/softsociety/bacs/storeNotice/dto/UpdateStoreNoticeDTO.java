package net.softsociety.bacs.storeNotice.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record UpdateStoreNoticeDTO(
        @NotBlank
        long noticeNo,
        @NotBlank
        String noticeTitle,
        @NotBlank
        String noticeContents
) {}
