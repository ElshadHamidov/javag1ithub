package az.azerbook.book.response;

import java.util.List;

import az.azerbook.book.entity.BookEntity;
import lombok.Data;

@Data
public class BookListResponse {

	private List<BookEntity> BookResponse;
}