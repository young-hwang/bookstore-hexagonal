package me.bookstore.domain.book.repository;

import me.bookstore.domain.book.model.Book;
import me.bookstore.domain.book.model.BookId;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(BookId bookId);
    void save(Book book);
    List<Book> findByIds(List<BookId> bookIds);
}
