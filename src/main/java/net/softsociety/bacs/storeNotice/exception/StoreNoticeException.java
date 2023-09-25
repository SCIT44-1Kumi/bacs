package net.softsociety.bacs.storeNotice.exception;

import net.softsociety.bacs.common.exception.CustomException;
import net.softsociety.bacs.common.exception.ErrorCode;

public class StoreNoticeException extends CustomException {

    public StoreNoticeException() {
    }

    public StoreNoticeException(String message) {
        super(message);
    }

    public StoreNoticeException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreNoticeException(ErrorCode errorCode) {
        super(errorCode);
    }

    public StoreNoticeException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
