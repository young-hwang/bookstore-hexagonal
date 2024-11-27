package me.bookstore.infrastructure.book;

import lombok.RequiredArgsConstructor;
import me.bookstore.domain.book.model.Book;
import me.bookstore.domain.book.model.BookId;
import me.bookstore.domain.book.repository.BookRepository;
import me.bookstore.domain.order.model.Order;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
@ConditionalOnProperty(name = "order.repository.type", havingValue = "memory", matchIfMissing = true)
public class BookRepositoryInMemoryAdapter implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    @Override
    public Optional<Book> findById(BookId bookId) {
        return Optional.ofNullable(books.get(bookId.value()));
    }

    @Override
    public void save(Book book) {
        books.put(book.getId().value(), book);
    }

    @Override
    public List<Book> findByIds(List<BookId> bookIds) {
        return books.values().stream()
                .filter(book -> bookIds.contains(book.getId()))
                .collect(Collectors.toList());
    }
}
