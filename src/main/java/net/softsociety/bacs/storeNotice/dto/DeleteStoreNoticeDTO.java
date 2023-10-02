package net.softsociety.bacs.storeNotice.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public record DeleteStoreNoticeDTO(
        @NotBlank
        long noticeNo
) {}
