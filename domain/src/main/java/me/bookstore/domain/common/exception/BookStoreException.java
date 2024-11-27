package me.bookstore.domain.common.exception;

public abstract class BookStoreException extends RuntimeException {
    public BookStoreException(String message) {
        super(message);
    }
}
