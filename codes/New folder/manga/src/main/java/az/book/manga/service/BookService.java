package az.book.manga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.book.manga.dto.BookRequestDto;
import az.book.manga.model.Book;
import az.book.manga.model.Reader;
import az.book.manga.repository.BookRepository;
import az.book.manga.repository.ReaderRepository;
import az.book.manga.response.BookResponse;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;

    public void add(BookRequestDto dto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Reader reader = readerRepository.getReaderByUsername(username);
        Integer id = reader.getId();

        Book book = new Book();
        book.setId(null);
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        book.setYear(dto.getYear());
        book.setReaderId(id);
        bookRepository.save(book);
    }

    public BookResponse get() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Reader reader = readerRepository.getReaderByUsername(username);
        Integer id = reader.getId();

        BookResponse response = new BookResponse();
        response.setBooks(bookRepository.findByReaderId(id));
        return response;
    }
}
