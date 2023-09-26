package net.softsociety.bacs.notice.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Optional<Notice> findByNoticeNum(int noticeNum);
}
