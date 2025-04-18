package az.book.manga.repository;

import az.book.manga.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthor(String author);

    List<Book> findByTitleContainingIgnoreCase(String keyword);
}