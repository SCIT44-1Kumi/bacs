package net.softsociety.bacs.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@ConfigurationProperties("app.jwt")
@ConfigurationPropertiesBinding
public record JwtProperties(
        String secret,
        Long expireIn
) {
    // Compact Constructor 컴팩트 생성자
    public JwtProperties {
        if (expireIn == null) {
            expireIn = 1_800_000L;
        }
    }
}
