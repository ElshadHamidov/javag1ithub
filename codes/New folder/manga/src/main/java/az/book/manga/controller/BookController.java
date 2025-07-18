package az.book.manga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import az.book.manga.dto.BookRequestDto;
import az.book.manga.response.BookResponse;
import az.book.manga.service.BookService;
import az.book.manga.model.Book;
import az.book.manga.model.TestEntity;
import az.book.manga.dynamic.DynamicFiltering;
import az.book.manga.repository.BookRepository;
import az.book.manga.response.BookListResponseModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Book Controller", description = "Book APIs")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/add")
    @PreAuthorize("hasAuthority('ROLE_ADD_BOOK')")
    public void create(@RequestBody BookRequestDto dto) {
        bookService.add(dto);
    }

    private Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping(path = "/getAll")
    @Operation(description = "Get API for Book", summary = "This is a summary for Book get API")
    public BookResponse getAll() {
        return bookService.get();
    }

    @GetMapping(path = "/pagination/begin/{begin}/length/{length}")
    public List<Book> pagination(@PathVariable Integer begin, @PathVariable Integer length) {
        return bookService.findPagination(begin, length);
    }

    @GetMapping(path = "/title")
    public List<String> getBookTitles() {
        return bookService.getBookTitle();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
    }

    @GetMapping(path = "/{id}")
    public BookResponseDto getById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @GetMapping(path = "/view")
     log.info("GET books/getAll cagirildi");

    public List<TestEntity> getView() {
        return movieService.findView();
    }
    log.info("PUT api cagirildi" + dto);
}