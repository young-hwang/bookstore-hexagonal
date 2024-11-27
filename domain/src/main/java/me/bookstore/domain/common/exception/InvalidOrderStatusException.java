package me.bookstore.domain.common.exception;

import me.bookstore.domain.order.model.OrderId;
import me.bookstore.domain.order.model.OrderStatus;

public class InvalidOrderStatusException extends BookStoreException{
    public InvalidOrderStatusException(OrderId id, OrderStatus expected, OrderStatus actual) {
        super(String.format("Order %s has invalid status. Expected: %s, Actual: %s", id, expected, actual));
    }
}
