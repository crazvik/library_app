package se.ecutb.library_app.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.ecutb.library_app.services.BookService;

import se.ecutb.library_app.entities.Book;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks(String title) {
        return ResponseEntity.ok(bookService.findAll(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable String id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping
    public ResponseEntity<Book> saveBook(@Validated @RequestBody Book book) {
        return ResponseEntity.ok(bookService.create(book));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PutMapping
    public void updateBook(@RequestParam(required = false) String id, @Validated @RequestBody Book book) {
        bookService.update(id, book);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping
    public void deleteBook(@RequestParam(required = false) String id) {
        bookService.delete(id);
    }
}
