package se.ecutb.library_app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.ecutb.library_app.entities.Book;
import se.ecutb.library_app.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(String id) {
        return bookRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Couldn't find book with id %s", id)));
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(String id, Book book) {
        if(!bookRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Couldn't find book with id %s", id));
        }
        book.setId(id);
        return bookRepository.save(book);
    }

    public void delete(String id) {
        if(!bookRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Couldn't not find book with id %s", id));
        }
        bookRepository.deleteById(id);
    }
}
