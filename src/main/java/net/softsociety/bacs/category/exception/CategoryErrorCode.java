package net.softsociety.bacs.category.exception;

import lombok.RequiredArgsConstructor;
import net.softsociety.bacs.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum CategoryErrorCode implements ErrorCode {

    CATEGORY_CONFLICT("이미 존재하는 카테고리입니다.", HttpStatus.CONFLICT),
    DEFAULT("카테고리 생성 실패", HttpStatus.INTERNAL_SERVER_ERROR),

    CATEGORY_NULL("카테고리가 존재하지 않습니다.", HttpStatus.NOT_FOUND);

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
        return new CategoryException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new CategoryException(this, cause);
    }
}
