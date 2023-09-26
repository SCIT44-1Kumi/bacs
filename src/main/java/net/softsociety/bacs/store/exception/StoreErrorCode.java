package net.softsociety.bacs.store.exception;

import lombok.RequiredArgsConstructor;
import net.softsociety.bacs.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum StoreErrorCode implements ErrorCode {

    STORE_CONFLICT("이미 존재하는 매장입니다.", HttpStatus.CONFLICT),
    DEFAULT("매장 생성 실패", HttpStatus.INTERNAL_SERVER_ERROR),

    STORE_NULL("매장이 존재하지 않습니다.", HttpStatus.NOT_FOUND);

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
        return new StoreException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new StoreException(this, cause);
    }
}
