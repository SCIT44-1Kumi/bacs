package net.softsociety.bacs.notice.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record EditNoticeDTO(
        @NotBlank
        int noticeNum,
        @NotBlank
        String noticeTitle,
        @NotBlank
        String noticeContents,
        @NotBlank
        String userId
) {}
