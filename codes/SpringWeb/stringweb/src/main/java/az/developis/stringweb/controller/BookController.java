package az.developis.stringweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BookController {

    @GetMapping("/books")
    public String getBooks() {
        return "books";
    }
}
