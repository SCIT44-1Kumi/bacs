package net.softsociety.bacs.menu.exception;

import lombok.RequiredArgsConstructor;
import net.softsociety.bacs.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum MenuErrorCode implements ErrorCode {

    MENU_CONFLICT("이미 존재하는 메뉴 입니다.", HttpStatus.CONFLICT),
    MENU_OPTION_CONFLICT("이미 존재하는 옵션 입니다.", HttpStatus.CONFLICT),
    DEFAULT("메뉴 생성 실패", HttpStatus.INTERNAL_SERVER_ERROR),

    MENU_NULL("메뉴가 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    MENU_OPTION_NULL("옵션이 존재하지 않습니다.", HttpStatus.NOT_FOUND);

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
        return new MenuException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new MenuException(this, cause);
    }
}
