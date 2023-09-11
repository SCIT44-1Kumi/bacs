package net.softsociety.bacs.user.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

// Builder record

@Builder
public record LoginResponseDto(
        @JsonInclude(Include.NON_EMPTY) // exclude when null, ""
        String token, // { "requires2Fa": true }

        @JsonInclude(Include.NON_DEFAULT) // exclude when null, false, 0, ...
        Boolean requires2Fa
) {
}
