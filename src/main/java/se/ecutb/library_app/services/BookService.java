package se.ecutb.library_app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import se.ecutb.library_app.entities.Book;
import se.ecutb.library_app.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Cacheable(value = "bookCache")
    public List<Book> findAll(String title) {
        return bookRepository.findAll();
    }

    @CachePut(value = "bookCache", key = "#result.id")
    public Book create(Book book) {
        return bookRepository.save(book);
    }
}
