package me.bookstore.infrastructure.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "books")
@Entity
public class BookEntity {
    @Id
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private int stockQuantity;
    private String status;
}
