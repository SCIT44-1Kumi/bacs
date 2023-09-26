package net.softsociety.bacs.notice.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;


@Builder
public record CreateNoticeDTO(
        @NotBlank
        String userId,
        @NotBlank
        String noticeTitle,
        @NotBlank
        String noticeContents
) {}
