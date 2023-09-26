package net.softsociety.bacs.store.exception;

import net.softsociety.bacs.common.exception.CustomException;
import net.softsociety.bacs.common.exception.ErrorCode;

public class StoreException extends CustomException {

    public StoreException() {
    }

    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreException(ErrorCode errorCode) {
        super(errorCode);
    }

    public StoreException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
