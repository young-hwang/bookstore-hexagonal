package me.bookstore.domain.order.repository;

import me.bookstore.domain.order.model.Order;
import me.bookstore.domain.order.model.OrderId;
import me.bookstore.domain.user.model.UserId;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(OrderId orderId);
    void delete(OrderId orderId);
    List<Order> findByUserId(UserId userId);
}
