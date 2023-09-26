package net.softsociety.bacs.order.service;

import net.softsociety.bacs.order.dto.CreateOrderDTO;

public interface OrderService {
    void createOrder(String storeId, CreateOrderDTO dto);
}
