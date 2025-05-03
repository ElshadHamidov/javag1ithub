package az.book.manga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.book.manga.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByReaderId(Integer id);
}
