package net.softsociety.bacs.notice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.notice.dto.CreateNoticeDTO;
import net.softsociety.bacs.notice.dto.DeleteNoticeDTO;
import net.softsociety.bacs.notice.dto.EditNoticeDTO;
import net.softsociety.bacs.notice.entity.Notice;
import net.softsociety.bacs.notice.entity.NoticeRepository;
import net.softsociety.bacs.notice.exception.NoticeErrorCode;
import net.softsociety.bacs.user.entity.User;
import net.softsociety.bacs.user.entity.UserRepository;
import net.softsociety.bacs.user.exception.AuthenticationErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {


    private final NoticeRepository noticeRepository;
    private final UserRepository userRepository;

    @Override
    public void create(CreateNoticeDTO data) {
        User user = userRepository.findByUserId(data.userId())
                .orElseThrow(AuthenticationErrorCode.USER_NULL::defaultException);

        Notice notice = Notice.builder()
                .noticeTitle(data.noticeTitle())
                .noticeContents(data.noticeContents())
                .build();

        log.debug("---------new Notice: {}", notice);
        noticeRepository.save(notice);
        user.addNotices(notice);
    }

    @Override
    public void delete(DeleteNoticeDTO data) {
        Notice notice = noticeRepository.findByNoticeNum(data.noticeNum())
                .orElseThrow(NoticeErrorCode.NOTICE_NULL::defaultException);

        User user = userRepository.findByUserId(data.userId())
                .orElseThrow(AuthenticationErrorCode.USER_NULL::defaultException);

        noticeRepository.delete(notice);
        user.removeNotices(notice);
    }

    @Override
    public List<Notice> read() {
        return noticeRepository.findAll();
    }


    @Override
    public void edit(EditNoticeDTO data) {
        Notice notice = noticeRepository.findByNoticeNum(data.noticeNum())
                .orElseThrow(NoticeErrorCode.NOTICE_NULL::defaultException);

        notice.update(data.noticeTitle(), data.noticeContents());
    }

    @Override
    public Notice readOne(int noticeNum){
        return noticeRepository.findByNoticeNum(noticeNum)
                .orElseThrow(NoticeErrorCode.NOTICE_NULL::defaultException);
    }

}
