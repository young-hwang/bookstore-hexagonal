package me.bookstore.application.service;

import lombok.RequiredArgsConstructor;
import me.bookstore.domain.order.model.Order;
import me.bookstore.domain.order.model.OrderId;
import me.bookstore.domain.order.model.OrderLine;
import me.bookstore.domain.order.service.OrderService;
import me.bookstore.domain.order.usecase.CreateOrderCommand;
import me.bookstore.domain.order.usecase.CreateOrderUseCase;
import me.bookstore.domain.user.model.UserId;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CreateOrderService implements CreateOrderUseCase {
    private final OrderService orderService;

    @Override
    public OrderId createOrder(CreateOrderCommand command) {
        UserId userId = command.userId();
        List<OrderLine> orderLines = command.orderLines().stream()
                .map(line -> new OrderLine(line.bookId(), line.Quantity(), null)) // Assuming price is set elsewhere
                .toList();
        Order order = orderService.createOrder(new OrderId(null), userId, orderLines);
        return order.getId();
    }
}
