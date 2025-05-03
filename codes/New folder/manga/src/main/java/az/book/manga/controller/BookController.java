package az.book.manga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
