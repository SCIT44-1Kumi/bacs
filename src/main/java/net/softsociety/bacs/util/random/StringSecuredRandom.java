package net.softsociety.bacs.util.random;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64.Encoder;

@Component
@RequiredArgsConstructor
public final class StringSecuredRandom {

    private final Encoder encoder;
    private final SecureRandom random;

    public String next(int length) {
        return nextBytes(length)
//                .replaceAll("-", "_")
                .substring(0, length);
    }

    public String nextBytes(int byteSize) {
        byte[] bytes = new byte[byteSize];
        random.nextBytes(bytes); // call by reference

        return encoder.encodeToString(bytes); // to BASE64
    }
}
