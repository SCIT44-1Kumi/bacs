package net.softsociety.bacs.storeNotice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
public record DeleteStoreNoticeDTO(
        @NotBlank
        int noticeNum
) {}
