package az.book.manga.service;

import az.book.manga.model.Book;
import az.book.manga.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Long id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
