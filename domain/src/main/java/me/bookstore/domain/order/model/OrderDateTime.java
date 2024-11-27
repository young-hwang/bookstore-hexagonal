package me.bookstore.domain.order.model;

import java.time.LocalDateTime;

public record OrderDateTime(LocalDateTime dateTime) {
    public static OrderDateTime now() {
        return new OrderDateTime(LocalDateTime.now());
    }

    public boolean isBefore(OrderDateTime other) {
        return this.dateTime.isBefore(other.dateTime);
    }

    public boolean isAfter(OrderDateTime other) {
        return this.dateTime.isAfter(other.dateTime);
    }
}
