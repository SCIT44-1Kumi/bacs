package net.softsociety.bacs.storeNotice.entity;

import net.softsociety.bacs.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreNoticeRepository extends JpaRepository<StoreNotice, Long> {
    Optional<StoreNotice> findById(Long id);
    List<StoreNotice> findByStore(Store store);
}
