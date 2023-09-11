package net.softsociety.bacs.user.redis.repository;

import net.softsociety.bacs.user.redis.entity.UserRefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefreshTokenRepository extends CrudRepository<UserRefreshToken, String> {
    List<UserRefreshToken> findAllByUserId(String userId);
}
