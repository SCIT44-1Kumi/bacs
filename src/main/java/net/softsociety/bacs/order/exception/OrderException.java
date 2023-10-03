package net.softsociety.bacs.order.exception;

import net.softsociety.bacs.common.exception.CustomException;
import net.softsociety.bacs.common.exception.ErrorCode;

public class OrderException extends CustomException {

    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderException(ErrorCode errorCode) {
        super(errorCode);
    }

    public OrderException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
