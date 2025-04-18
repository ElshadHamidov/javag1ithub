package az.book.manga.service;

import az.book.manga.model.Book;
import az.book.manga.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> searchBooksByTitle(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
