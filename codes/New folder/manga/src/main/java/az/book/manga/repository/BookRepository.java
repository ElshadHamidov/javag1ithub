package az.book.manga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.book.manga.model.Book;

import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT title FROM books", nativeQuery = true)
    List<String> findAllBookTitles();
}