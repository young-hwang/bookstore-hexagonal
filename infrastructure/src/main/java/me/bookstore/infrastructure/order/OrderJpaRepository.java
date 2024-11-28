package me.bookstore.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
    Collection<OrderEntity> findByUserId(Long id);

    @Query("SELECT o FROM OrderEntity o JOIN FETCH o.orderLines WHERE o.id = :id")
    Optional<OrderEntity> findByIdWithOrderLines(@Param("id") Long id);
}
