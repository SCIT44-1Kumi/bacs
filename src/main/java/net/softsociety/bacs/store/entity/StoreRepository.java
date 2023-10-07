package net.softsociety.bacs.store.entity;

import net.softsociety.bacs.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByStoreId(String storeId);
    Optional<Store> findByUser(User user);

    

}
