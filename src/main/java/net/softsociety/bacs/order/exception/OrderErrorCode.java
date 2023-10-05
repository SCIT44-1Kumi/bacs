package net.softsociety.bacs.order.exception;

import lombok.RequiredArgsConstructor;
import net.softsociety.bacs.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum OrderErrorCode implements ErrorCode {

    ORDER_CONFLICT("이미 존재하는 주문 입니다.", HttpStatus.CONFLICT),
    DEFAULT("주문 조회 실패", HttpStatus.INTERNAL_SERVER_ERROR),

    ORDER_NULL("주문이 존재하지 않습니다.", HttpStatus.NOT_FOUND);


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
        return new OrderException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new OrderException(this, cause);
    }
}
