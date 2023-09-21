package net.softsociety.bacs.user.redis.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import static java.util.concurrent.TimeUnit.SECONDS;

@RedisHash("user_refresh_token")
@Builder
@ToString
@EqualsAndHashCode
public class UserRefreshToken {
    @Id
    public String refreshToken; // K-V "user_refresh_token:{id}"

    @Indexed // where절 같은
    public String userId;

    // ... (접속 국가, 접속 기기, ...)

    @TimeToLive(unit = SECONDS)
    public Long ttl;
}
