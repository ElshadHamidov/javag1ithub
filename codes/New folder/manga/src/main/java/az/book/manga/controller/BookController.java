package az.book.manga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.book.manga.dto.BookRequestDto;
import az.book.manga.response.BookResponse;
import az.book.manga.service.BookService;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getBook() {
        return "get book";
    }

    @PostMapping(path = "/add")
    public void create(@RequestBody BookRequestDto dto) {
        bookService.add(dto);
    }

    @GetMapping(path = "/getAll")
    public BookResponse getAll() {
        return bookService.get();
    }

    @GetMapping(path = "/title")
    public List<String> getBookTitles() {
        return bookService.getBookTitles();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
    }
}
