package net.softsociety.bacs.notice.exception;

import net.softsociety.bacs.common.exception.CustomException;
import net.softsociety.bacs.common.exception.ErrorCode;

public class NoticeException extends CustomException {

    public NoticeException() {
    }

    public NoticeException(String message) {
        super(message);
    }

    public NoticeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoticeException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NoticeException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
