package az.developis.stringweb.controller;

import az.developis.stringweb.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    private List<Book> bookList = List.of(
        new Book("The Alchemist", "Paulo Coelho", 1988),
        new Book("1984", "George Orwell", 1949),
        new Book("To Kill a Mockingbird", "Harper Lee", 1960),
        new Book("Animal Farm", "George Orwell", 1945),
        new Book("Brida", "Paulo Coelho", 1990)
    );

    @GetMapping("/books")
    public String getBooks(@RequestParam(required = false) String author, Model model) {
        List<Book> filteredBooks = bookList;

        if (author != null && !author.isEmpty()) {
            filteredBooks = bookList.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        }

        model.addAttribute("books", filteredBooks);
        return "book";
    }
}
