package me.bookstore.presentation.controller;

import lombok.RequiredArgsConstructor;
import me.bookstore.application.service.CreateOrderService;
import me.bookstore.application.service.RetrieveOrderService;
import me.bookstore.domain.order.model.Order;
import me.bookstore.domain.order.model.OrderId;
import me.bookstore.domain.order.usecase.CreateOrderCommand;
import me.bookstore.domain.order.usecase.CreateOrderUseCase;
import me.bookstore.domain.order.usecase.RetrieveOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final CreateOrderUseCase createOrderService;
    private final RetrieveOrderUseCase retrieveOrderService;

    @PostMapping("/orders")
    public ResponseEntity<OrderId> createOrder(@RequestBody CreateOrderCommand command) {
        OrderId orderId = createOrderService.createOrder(command);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Optional<Order> order = retrieveOrderService.getOrderById(new OrderId(orderId));
        return order.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
