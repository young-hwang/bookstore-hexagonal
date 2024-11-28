package me.bookstore.application.service;

import lombok.RequiredArgsConstructor;
import me.bookstore.domain.order.model.Order;
import me.bookstore.domain.order.model.OrderId;
import me.bookstore.domain.order.repository.OrderRepository;
import me.bookstore.domain.order.service.OrderService;
import me.bookstore.domain.order.usecase.RetrieveOrderUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RetrieveOrderService implements RetrieveOrderUseCase {
    private final OrderService orderService;

    @Override
    public Optional<Order> getOrderById(OrderId orderId) {
        return orderService.getOrderById(orderId);
    }
}
