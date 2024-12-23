package me.bookstore.infrastructure.order;

import lombok.RequiredArgsConstructor;
import me.bookstore.domain.order.model.Order;
import me.bookstore.domain.order.model.OrderId;
import me.bookstore.domain.order.repository.OrderRepository;
import me.bookstore.domain.user.model.UserId;
import org.springframework.stereotype.Repository;

import java.io.Console;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryJpaAdapter implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order save(Order order) {
        OrderEntity entity = orderMapper.toEntity(order);
        OrderEntity savedEntity = orderJpaRepository.save(entity);
        return orderMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        System.out.println("findById Order");
        return orderJpaRepository.findByIdWithOrderLines(orderId.id())
                .map(orderMapper::toDomain);
    }

    @Override
    public void delete(OrderId orderId) {
        orderJpaRepository.deleteById(orderId.id());
    }

    @Override
    public List<Order> findByUserId(UserId userId) {
        return orderJpaRepository.findByUserId(userId.id())
                .stream()
                .map(orderMapper::toDomain)
                .collect(Collectors.toList());
    }
}
