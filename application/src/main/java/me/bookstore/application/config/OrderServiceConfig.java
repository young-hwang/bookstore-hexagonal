package me.bookstore.application.config;

import lombok.RequiredArgsConstructor;
import me.bookstore.domain.book.repository.BookRepository;
import me.bookstore.domain.order.repository.OrderRepository;
import me.bookstore.domain.order.service.OrderService;
import me.bookstore.infrastructure.order.OrderJpaRepository;
import me.bookstore.infrastructure.order.OrderMapper;
import me.bookstore.infrastructure.order.OrderRepositoryInMemoryAdapter;
import me.bookstore.infrastructure.order.OrderRepositoryJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Configuration
public class OrderServiceConfig {
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    @Bean
    public OrderService orderService() {
        return new OrderService(orderRepository, bookRepository);
    }
}
