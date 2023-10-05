package net.softsociety.bacs.store.dto;

import lombok.Builder;
import javax.validation.constraints.NotBlank;

@Builder
public record SaleTodayDTO(
        @NotBlank
        String storeId
) {



}
