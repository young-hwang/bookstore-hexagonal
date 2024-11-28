package me.bookstore.infrastructure.book;

import lombok.RequiredArgsConstructor;
import me.bookstore.domain.book.model.Book;
import me.bookstore.domain.book.model.BookId;
import me.bookstore.domain.book.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class BookRepositoryJpaAdapter implements BookRepository {
    private final BookJpaRepository bookJpaRepository;
    private final BookMapper bookMapper;

    @Override
    public Optional<Book> findById(BookId bookId) {
        return bookJpaRepository.findById(bookId.value()).map(bookMapper::toDomain);
    }

    @Override
    public void save(Book book) {
        BookEntity entity = bookMapper.toEntity(book);
        bookJpaRepository.save(entity);
    }

    @Override
    public List<Book> findByIds(List<BookId> bookIds) {
        return bookJpaRepository.findByIdIn(bookIds.stream().map(BookId::value).collect(Collectors.toList()))
                .stream()
                .map(bookMapper::toDomain)
                .collect(Collectors.toList());
    }
}
