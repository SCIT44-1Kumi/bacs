package net.softsociety.bacs.user.exception;

import lombok.RequiredArgsConstructor;
import net.softsociety.bacs.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor // Not Null, final
public enum AuthenticationErrorCode implements ErrorCode {
    ID_PW_MISMATCHED("아이디 혹은 패스워드가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    DEFAULT("인증 실패", HttpStatus.INTERNAL_SERVER_ERROR),

    USER_CONFLICT("중복된 아이디 입니다", HttpStatus.CONFLICT),

    USER_NULL("유저가 존재하지 않습니다.", HttpStatus.NOT_FOUND);

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
    public AuthenticationException defaultException() {
        return new AuthenticationException(this);
    }

    @Override
    public AuthenticationException defaultException(Throwable cause) {
        return new AuthenticationException(this, cause);
    }
}
