package net.softsociety.bacs.kiosk.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KioskRepository extends JpaRepository<Kiosk, Long> {
    Optional<Kiosk> findById(Long id);
}
