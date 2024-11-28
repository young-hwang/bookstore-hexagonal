package me.bookstore.application.config;

import lombok.RequiredArgsConstructor;
import me.bookstore.application.repository.BookRepositoryInMemoryAdapter;
import me.bookstore.application.repository.OrderRepositoryInMemoryAdapter;
import me.bookstore.domain.book.repository.BookRepository;
import me.bookstore.domain.order.repository.OrderRepository;
import me.bookstore.domain.order.service.OrderService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class OrderServiceConfig {
    @Bean
    @ConditionalOnMissingBean(OrderRepository.class)
    public OrderRepository orderRepository() {
        System.out.println("Create OrderRepository");
        return new OrderRepositoryInMemoryAdapter();
    }

    @Bean
    @ConditionalOnMissingBean(BookRepository.class)
    public BookRepository bookRepository() {
        System.out.println("Create BookRepository");
        return new BookRepositoryInMemoryAdapter();
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository, BookRepository bookRepository) {
        System.out.println("OrderRepository: " + orderRepository.getClass().getName());
        return new OrderService(orderRepository, bookRepository);
    }

}
