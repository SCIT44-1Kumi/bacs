package net.softsociety.bacs.storeNotice.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record CreateStoreNoticeDTO(
        @NotBlank
        String noticeTitle,
        @NotBlank
        String noticeContents
) {}
