package me.bookstore.domain.order.usecase;

import me.bookstore.domain.order.model.Order;
import me.bookstore.domain.order.model.OrderId;

import java.util.Optional;

public interface RetrieveOrderUseCase {
    Optional<Order> getOrderById(OrderId orderId);
}
