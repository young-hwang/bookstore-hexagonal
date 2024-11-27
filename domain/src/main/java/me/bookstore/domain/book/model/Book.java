package me.bookstore.domain.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.bookstore.domain.common.model.Money;

@Getter
@AllArgsConstructor
public class Book {
    private final BookId id;
    private String title;
    private String author;
    private String isbn;
    private Money price;
    private int stockQuantity;
    private BookStatus status;

    public void updateStock(int quantity) {
        if (this.stockQuantity + quantity < 0) {
            throw new IllegalArgumentException("재고는 0 이하가 될 수 없습니다.");
        }
        this.stockQuantity += quantity;
    }

    public boolean isAvailable() {
        return this.status == BookStatus.AVAILABLE && this.stockQuantity > 0;
    }
}
