package net.softsociety.bacs.user.service.data;

import lombok.Builder;

@Builder
public record TokenPair(
        String accessToken,
        String refreshToken
) {
}
