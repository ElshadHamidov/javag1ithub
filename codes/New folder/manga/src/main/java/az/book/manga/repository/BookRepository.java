package az.book.manga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.book.manga.model.Book;

import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByUserId(Integer id);

    @Query(value = "DELETE FROM books WHERE user_id = ?1", nativeQuery = true)
    @Modifying
    void deleteUserBooks(Integer userId);

    @Query(value = "SELECT title FROM books", nativeQuery = true)
    List<String> getBookTitles();

    @Query(value = "Select * from movies limit ?1, ?2",nativeQuery = true)More actions
	List<Movie> pagination(Integer b, Integer l);
}
