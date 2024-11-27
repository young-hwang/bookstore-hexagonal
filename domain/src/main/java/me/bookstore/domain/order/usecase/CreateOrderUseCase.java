package me.bookstore.domain.order.usecase;

import me.bookstore.domain.order.model.OrderId;

public interface CreateOrderUseCase {
    OrderId createOrder(CreateOrderCommand command);
}
