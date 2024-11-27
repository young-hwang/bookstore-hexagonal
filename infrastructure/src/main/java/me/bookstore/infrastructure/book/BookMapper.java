package me.bookstore.infrastructure.book;

import me.bookstore.domain.book.model.Book;
import me.bookstore.domain.book.model.BookId;
import me.bookstore.domain.book.model.BookStatus;
import me.bookstore.domain.common.model.Money;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toDomain(BookEntity entity) {
        return new Book(
            new BookId(entity.getId()),
            entity.getTitle(),
            entity.getAuthor(),
            entity.getIsbn(),
            Money.of(entity.getPrice()),
            entity.getStockQuantity(),
            BookStatus.valueOf(entity.getStatus())
        );
    }

    public BookEntity toEntity(Book book) {
        BookEntity entity = new BookEntity();
        entity.setId(book.getId().value());
        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setIsbn(book.getIsbn());
        entity.setPrice(book.getPrice().getAmount());
        entity.setStockQuantity(book.getStockQuantity());
        entity.setStatus(book.getStatus().name());
        return entity;
    }
}
