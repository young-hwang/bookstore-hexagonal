package me.bookstore.infrastructure.order;

import me.bookstore.domain.book.model.BookId;
import me.bookstore.domain.common.model.Money;
import me.bookstore.domain.order.model.Order;
import me.bookstore.domain.order.model.OrderId;
import me.bookstore.domain.order.model.OrderLine;
import me.bookstore.domain.user.model.UserId;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order toDomain(OrderEntity entity) {
        return new Order(
            new OrderId(entity.getId()),
            new UserId(entity.getUserId()),
                entity.getOrderLines().stream().map(this::toDomain).collect(Collectors.toList())
        );
    }

    public OrderEntity toEntity(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId().id());
        entity.setUserId(order.getUserId().id());
        entity.setOrderLines(order.getOrderLines().stream().map(this::toEntity).collect(Collectors.toList()));
        entity.setStatus(order.getStatus());
        entity.setOrderDateTime(order.getOrderDateTime().dateTime());
        return entity;
    }

    private OrderLine toDomain(OrderLineEntity entity) {
        return new OrderLine(
            new BookId(entity.getBookId()),
            entity.getQuantity(),
            Money.of(entity.getPrice())
        );
    }

    private OrderLineEntity toEntity(OrderLine orderLine) {
        OrderLineEntity entity = new OrderLineEntity();
        entity.setBookId(orderLine.bookId().value());
        entity.setQuantity(orderLine.quantity());
        entity.setPrice(orderLine.price().getAmount());
        return entity;
    }
}
