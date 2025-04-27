package az.book.manga.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Books")
@CrossOrigin(origins = "*")
public class BookController {

	@GetMapping
	public String getBook() {
		return "get Book";
	}
}