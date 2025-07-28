package az.azerbook.reader.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import az.azerbook.reader.entity.ReaderEntity;
import az.azerbook.reader.repository.ReaderRepository;
import az.azerbook.reader.response.BookListResponse;
import az.azerbook.reader.response.ReaderListResponse;
import az.azerbook.reader.response.ReaderResponse;

@RestController
@RequestMapping(path = "/readers")
@CrossOrigin(origins = "*")
public class ReaderController {

	@Autowired
	private ReaderRepository readerRepository;
	
	@GetMapping(path = "/getAll")
	public ReaderListResponse getReader() {
		ReaderListResponse resp = new ReaderListResponse();
		
		List<ReaderEntity> readers = readerRepository.findAll();
		
		resp.setReaderResponse(readers);
		
		return resp;
		@GetMapping(path = "/width-books")
	public ReaderListResponse readerwitdhBooks() {
		ReaderListResponse resp = new ReaderListResponse();
		
		RestTemplate rest = new RestTemplate();
		
		List<ReaderEntity> Readers = ReaderRepository.findAll();
		
		
		List<ReaderResponse> readerWithBooks = new ArrayList<ReaderResponse>();
		
		for (ReaderEntity readerEntity : Readers) {
			ReaderResponse response = new ReaderResponse();
			response.setId(readerEntity.getId());
			response.setFirstName(readerEntity.getFirstName());
			response.setLastName(readerEntity.getLastName());
			
			BookListResponse bookResp = rest.getForObject("http://localhost:8001/books/reader/" + ReaderEntity.getId(), BookListResponse.class);
			
			response.setBooks(bookResp.getBookResponse());
			
			readerWithBooks.add(response);
		}
		resp.setReaderwitdhBooks(readerWithBooks);
		
		return resp;

	}
}