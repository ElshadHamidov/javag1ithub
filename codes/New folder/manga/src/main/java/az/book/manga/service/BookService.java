package az.book.manga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.book.manga.dto.BookRequestDto;
import az.book.manga.model.Book;
import az.book.manga.model.TestEntity;
import az.book.manga.model.User;
import az.book.manga.exception.OurRuntimeException;
import az.book.manga.repository.BookRepository;
import az.book.manga.repository.UserRepository;
import az.book.manga.repository.ViewRepository;
import az.book.manga.response.BookResponse;
import az.book.manga.response.BookResponseModel;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ViewRepository viewRepository;

    public void add(BookRequestDto dto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getUserByUsername(username);
        Integer id = user.getId();

        Book book = new Book();
        book.setId(null);
        // Book.setGenre(dto.getGenre());
        // Book.setRating(dto.getRating());
        // Book.setTitle(dto.getTitle());
        mapper.map(dto, Book);
        book.setUserId(id);
        bookRepository.save(book);
    }

    public BookResponse get() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getUserByUsername(username);
        Integer id = user.getId();

        BookResponse response = new BookResponse();

        List<Book> books = bookRepository.findByUserId(id);

        Function<Book, String> titleMapper = new Function<Book, String>() {
            @Override
            public String apply(Book t) {
                return t.getTitle();
            }
        };

        Predicate<String> filterByTitle = new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.contains("a");
            }
        };

        List<String> filteredTitles = books.stream()
                .map(titleMapper)
                .filter(filterByTitle)
                .collect(Collectors.toList());

        response.setBooks(filteredTitles);

        return response;
    }

    public List<String> getBookTitle() {
        return bookRepository.getBookNames();
    }

    public void delete(Integer id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User operatorUser = userRepository.getUserByUsername(username);

        if (id == null || id <= 0) {
            throw new OurRuntimeException(null, "id mutləqdir");
        }

        Supplier<OurRuntimeException> s = new Supplier<OurRuntimeException>() {
            @Override
            public OurRuntimeException get() {
                return new OurRuntimeException(null, "id tapılmadı");
            }
        };

        Book book = bookRepository.findById(id).orElseThrow(s);

        if (book.getUserId().equals(operatorUser.getId())) {
            bookRepository.deleteById(id);
        } else {
            throw new OurRuntimeException(null, "Öz kitabını silə bilərsən");
        }
    }

    public List<Book> findpagination(Integer begin, Integer length) {

        return bookRepository.pagination(begin, length);
    }

    public List<TestEntity> findView() {
		
		return viewRepository.findAll();
	}
    public List<BookResponseModel> convertBookToResponseModel(List<Book> Books) {
		// TODO Auto-generated method stub
		List<BookResponseModel> dtos = new ArrayList<BookResponseModel>();
		for (Book book : books) {
			BookResponseModel dto = new BookResponseModel();
			mapper.map(book, dto);
			dtos.add(dto);
		}
		return dtos;
	}
}