package net.softsociety.bacs.kiosk.exception;

import lombok.RequiredArgsConstructor;
import net.softsociety.bacs.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum KioskErrorCode implements ErrorCode {

    KIOSK_CONFLICT("이미 존재하는 키오스크입니다.", HttpStatus.CONFLICT),
    DEFAULT("키오스크 생성 실패", HttpStatus.INTERNAL_SERVER_ERROR),
    KIOSK_NULL("키오스크이 존재하지 않습니다.", HttpStatus.NOT_FOUND);

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
        return new KioskException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new KioskException(this, cause);
    }
}
