package net.softsociety.bacs.user.entity;

import net.softsociety.bacs.domain.vo.BacsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BacsUserRepository extends JpaRepository<BacsUser, Long> {
    Optional<BacsUser> findByUserId(String userId);
}
