package az.book.manga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.book.manga.dto.BookRequestDto;
import az.book.manga.model.Book;
import az.book.manga.model.Reader;
import az.book.manga.exception.OurRuntimeException;
import az.book.manga.repository.BookRepository;
import az.book.manga.repository.ReaderRepository;
import az.book.manga.response.BookResponse;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ReaderRepository readerRepository;

	public void add(BookRequestDto dto) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Reader reader = readerRepository.getReaderByUsername(username);
		Integer id = reader.getId();

		Book book = new Book();
		book.setId(null);
		book.setGenre(dto.getGenre());
		book.setRating(dto.getRating());
		book.setTitle(dto.getTitle());
		book.setReaderId(id);
		bookRepository.save(book);
	}

	public BookResponse get() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Reader reader = readerRepository.getReaderByUsername(username);
		Integer id = reader.getId();

		BookResponse response = new BookResponse();
		response.setBooks(bookRepository.findByReaderId(id));
		return response;
	}

	public List<String> getBookTitles() {
		return bookRepository.getBookNames();
	}

	public void delete(Integer id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Reader operatorReader = readerRepository.getReaderByUsername(username);

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "ID mütləqdir");
		}

		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			if (book.get().getReaderId().equals(operatorReader.getId())) {
				bookRepository.deleteById(id);
			} else {
				throw new OurRuntimeException(null, "Yalnız öz kitabınızı silə bilərsiniz");
			}
		} else {
			throw new OurRuntimeException(null, "Kitab tapılmadı");
		}
	}
}
