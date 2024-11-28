package me.bookstore.application.repository;

import me.bookstore.domain.order.model.Order;
import me.bookstore.domain.order.model.OrderId;
import me.bookstore.domain.order.repository.OrderRepository;
import me.bookstore.domain.user.model.UserId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderRepositoryInMemoryAdapter implements OrderRepository {
    private final Map<Long, Order> store = new HashMap<>();

    @Override
    public Order save(Order order) {
        store.put(order.getId().id(), order);
        return order;
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return Optional.ofNullable(store.get(orderId.id()));
    }

    @Override
    public void delete(OrderId orderId) {
        store.remove(orderId.id());
    }

    @Override
    public List<Order> findByUserId(UserId userId) {
        return store.values().stream()
                .filter(order -> order.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
