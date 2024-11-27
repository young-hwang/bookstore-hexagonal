package me.bookstore.domain.order.model;

import me.bookstore.domain.book.model.BookId;
import me.bookstore.domain.common.model.Money;

public record OrderLine(BookId bookId, Integer quantity, Money price) {
    public Money getAmount() {
        return this.price.multiply(this.quantity);
    }
}
