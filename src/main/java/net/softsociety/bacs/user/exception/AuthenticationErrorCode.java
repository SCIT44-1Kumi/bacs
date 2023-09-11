package net.softsociety.bacs.user.exception;

import lombok.RequiredArgsConstructor;
import net.softsociety.bacs.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor // Not Null, final
public enum AuthenticationErrorCode implements ErrorCode {
    ID_PW_MISMATCHED("", HttpStatus.BAD_REQUEST),
    DEFAULT("인증 실패", HttpStatus.INTERNAL_SERVER_ERROR);

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
