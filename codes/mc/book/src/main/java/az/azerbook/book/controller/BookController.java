package az.azerbook.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.azerbook.book.entity.BookEntity;
import az.azerbook.book.repository.BookRepository;
import az.azerbook.book.response.BookListResponse;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins = "*")
public class BookController {
@Autowired
	private BookRepository bookRepository;
	
	@GetMapping(path = "/user/{userId}")
	public BookListResponse getUserBooks(@PathVariable Integer userId) {
		
		BookListResponse response = new BookListResponse();
		
		List<BookEntity> books = bookRepository.findAllByUserId(userId);
		
		response.setBookResponse(books);
		return response;
	}
}
