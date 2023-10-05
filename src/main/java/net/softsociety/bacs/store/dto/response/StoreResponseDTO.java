package net.softsociety.bacs.store.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record StoreResponseDTO(
        @JsonInclude(Include.NON_EMPTY)
        Long storeNo,
        @JsonInclude(Include.NON_EMPTY)
        String storeName,
        @JsonInclude(Include.NON_EMPTY)
        String storeId,
        @JsonInclude(Include.NON_EMPTY)
        String storeAddress,
        @JsonInclude(Include.NON_EMPTY)
        String crNum,
        @JsonInclude(Include.NON_EMPTY)
        String storePhone,
        @JsonInclude(Include.NON_EMPTY)
        LocalDateTime createdAt
) {
}
