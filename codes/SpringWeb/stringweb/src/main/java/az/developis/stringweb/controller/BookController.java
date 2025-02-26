package az.developis.stringweb.controller;

import az.developis.stringweb.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = List.of(
            new Book("The Alchemist", "Paulo Coelho", 1988),
            new Book("1984", "George Orwell", 1949),
            new Book("To Kill a Mockingbird", "Harper Lee", 1960)
        );
        model.addAttribute("books", books);
        return "books";
    }
}
