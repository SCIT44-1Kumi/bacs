package net.softsociety.bacs.order.service;

import net.softsociety.bacs.order.dto.CreateOrderDTO;
import net.softsociety.bacs.order.entity.Order;
import net.softsociety.bacs.store.entity.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    void createOrder(String storeId, CreateOrderDTO dto);


  //  Optional<Order> orderlist(Store store);
}
