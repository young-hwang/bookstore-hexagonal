package me.bookstore.domain.order.service;

import lombok.RequiredArgsConstructor;
import me.bookstore.domain.book.model.Book;
import me.bookstore.domain.book.repository.BookRepository;
import me.bookstore.domain.common.exception.OutOfStockException;
import me.bookstore.domain.order.model.Order;
import me.bookstore.domain.order.model.OrderId;
import me.bookstore.domain.order.model.OrderLine;
import me.bookstore.domain.order.repository.OrderRepository;
import me.bookstore.domain.user.model.UserId;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    public Order createOrder(OrderId id, UserId userId, List<OrderLine> orderLines) {
        for (OrderLine orderLine : orderLines) {
            Book book = bookRepository.findById(orderLine.bookId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
            if (!book.isAvailable() || book.getStockQuantity() < orderLine.quantity()) {
                throw new OutOfStockException(orderLine.bookId());
            }
            book.updateStock(-orderLine.quantity());
        }
        Order order = new Order(id, userId, orderLines);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(OrderId orderId) {
        return orderRepository.findById(orderId);
    }
}
