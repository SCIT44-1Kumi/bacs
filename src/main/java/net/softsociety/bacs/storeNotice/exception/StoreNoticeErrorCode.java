package net.softsociety.bacs.storeNotice.exception;

import lombok.RequiredArgsConstructor;
import net.softsociety.bacs.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum StoreNoticeErrorCode implements ErrorCode {

    STORE_NOTICE_CONFLICT("이미 존재하는 공지입니다.", HttpStatus.CONFLICT),
    DEFAULT("공지 생성 실패", HttpStatus.INTERNAL_SERVER_ERROR),

    STORE_NOTICE_NULL("공지가 존재하지 않습니다.", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus status;

    @Override
    public String defaultMessage() {
        return message;
    }

    @Override
    public HttpStatus defaultHttpStatus() {
        return status;
    }

    @Override
    public RuntimeException defaultException() {
        return new StoreNoticeException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new StoreNoticeException(this, cause);
    }
}
