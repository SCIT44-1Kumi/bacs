package net.softsociety.bacs.kiosk.exception;

import net.softsociety.bacs.common.exception.CustomException;
import net.softsociety.bacs.common.exception.ErrorCode;

public class KioskException extends CustomException {

    public KioskException() {
    }

    public KioskException(String message) {
        super(message);
    }

    public KioskException(String message, Throwable cause) {
        super(message, cause);
    }

    public KioskException(ErrorCode errorCode) {
        super(errorCode);
    }

    public KioskException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
