package me.bookstore.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
    Collection<OrderEntity> findByUserId(Long id);
}
