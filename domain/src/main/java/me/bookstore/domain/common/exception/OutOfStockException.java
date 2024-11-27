package me.bookstore.domain.common.exception;

import me.bookstore.domain.book.model.BookId;

public class OutOfStockException extends BookStoreException {
    public OutOfStockException(BookId BookId) {
        super(String.format("Book with id %s is out of stock", BookId));
    }
}