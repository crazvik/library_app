package se.ecutb.library_app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.ecutb.library_app.entities.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
