package net.softsociety.bacs.notice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
public record DeleteNoticeDTO(
        @NotBlank
        String userId,
        @NotBlank
        long noticeNo
) {}
