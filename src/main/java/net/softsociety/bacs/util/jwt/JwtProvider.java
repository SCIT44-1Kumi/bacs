package net.softsociety.bacs.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import net.softsociety.bacs.common.properties.JwtProperties;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public final class JwtProvider {

    private final Key secretKey;
    private final Long expireIn;

    public JwtProvider(JwtProperties jwtProperties) { // @Value -> Configuration Properties 접근 (간단한 것)
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.secret());
        secretKey = Keys.hmacShaKeyFor(keyBytes);
        expireIn = jwtProperties.expireIn();
    }

    public String generate(String userId) {
        Map<String, String> claimsMap = new HashMap<>();
        claimsMap.put("authority", "USER");

        return generate(userId, claimsMap);
    }

    public String generate(String userId, Map<String, ?> claimsMap) {
        Claims claims = Jwts.claims().setSubject(userId);

        Date now = new Date();
        Date expireAt = new Date(now.getTime() + expireIn);

        claims.putAll(claimsMap); // <<< 한 번에 옮겨 담아 줌.

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireAt)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
}
