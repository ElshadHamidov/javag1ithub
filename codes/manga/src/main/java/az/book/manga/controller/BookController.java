package az.book.manga.controller;

import az.book.manga.exception.OurRuntimeException;
import az.book.manga.model.Book;
import az.book.manga.service.BookService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getById(id).orElse(null);
    }

    @PostMapping
    public Book createBook(@Valid @RequestBody Book book, BindingResult br) {
        if (br.hasErrors()) throw new OurRuntimeException(br);
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book book, BindingResult br) {
        if (br.hasErrors()) throw new OurRuntimeException(br);
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}
