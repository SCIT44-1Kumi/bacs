package net.softsociety.bacs.category.exception;

import net.softsociety.bacs.common.exception.CustomException;
import net.softsociety.bacs.common.exception.ErrorCode;

public class CategoryException extends CustomException {

    public CategoryException() {
    }

    public CategoryException(String message) {
        super(message);
    }

    public CategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryException(ErrorCode errorCode) {
        super(errorCode);
    }

    public CategoryException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
