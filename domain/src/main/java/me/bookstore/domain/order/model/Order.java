package me.bookstore.domain.order.model;

import lombok.Getter;
import me.bookstore.domain.common.exception.InvalidOrderStatusException;
import me.bookstore.domain.common.model.Money;
import me.bookstore.domain.user.model.UserId;

import java.util.List;

@Getter
public class Order {
    private final OrderId id;
    private final UserId userId;
    private final List<OrderLine> orderLines;
    private OrderStatus status;
    private final OrderDateTime orderDateTime;

    public Order(OrderId id, UserId userId, List<OrderLine> orderLines) {
        this.id = id;
        this.userId = userId;
        this.orderLines = orderLines;
        this.status = OrderStatus.CREATED;
        this.orderDateTime = OrderDateTime.now();
    }

    public Money calculateTotalAmount() {
        return orderLines.stream()
                .map(OrderLine::getAmount)
                .reduce(Money.zero(), Money::add);
    }

    public void confirm() {
        validateStatus(OrderStatus.CREATED);
        this.status = OrderStatus.CONFIRMED;
    }

    private void validateStatus(OrderStatus expectedStatus) {
        if (this.status != expectedStatus) {
            throw new InvalidOrderStatusException(id, expectedStatus, this.status);
        }
    }
}
