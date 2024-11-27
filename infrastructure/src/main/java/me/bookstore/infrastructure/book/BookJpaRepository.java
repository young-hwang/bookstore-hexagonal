package me.bookstore.infrastructure.book;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
    Collection<BookEntity> findByIdIn(@NotNull List<Long> collect);
}
