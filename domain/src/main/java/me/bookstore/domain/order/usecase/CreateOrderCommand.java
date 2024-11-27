package me.bookstore.domain.order.usecase;

import me.bookstore.domain.book.model.BookId;
import me.bookstore.domain.user.model.UserId;

import java.util.List;

public record CreateOrderCommand(UserId userId, List<OrderLineCommand> orderLines) {
    public record OrderLineCommand(BookId bookId, int Quantity) {
    }
}
