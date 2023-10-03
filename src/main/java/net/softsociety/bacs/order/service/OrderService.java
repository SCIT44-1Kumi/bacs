package net.softsociety.bacs.order.service;

import net.softsociety.bacs.order.dto.CreateOrderDTO;
import net.softsociety.bacs.order.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    void createOrder(String storeId, CreateOrderDTO dto);

  //  List<Order> orderList(String storeId);
}
