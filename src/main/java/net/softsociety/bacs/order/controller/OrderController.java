package net.softsociety.bacs.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.order.dto.CreateOrderDTO;
import net.softsociety.bacs.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("{storeId}/kiosk/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // TODO: 주문생성
    @PostMapping("create")
    public void createOrder(@PathVariable(name = "storeId") String storeId,
                            @RequestBody @Valid CreateOrderDTO dto
                            ) {
        orderService.createOrder(storeId, dto);
    }
    // TODO: 주문취소(삭제)
    // TODO: 주문조회(영수증)
}
