package net.softsociety.bacs.menu.exception;

import net.softsociety.bacs.common.exception.CustomException;
import net.softsociety.bacs.common.exception.ErrorCode;

public class MenuException extends CustomException {

    public MenuException() {
    }

    public MenuException(String message) {
        super(message);
    }

    public MenuException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuException(ErrorCode errorCode) {
        super(errorCode);
    }

    public MenuException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
