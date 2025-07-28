package az.azerbook.reader.response;

import java.util.List;

import lombok.Data;

@Data
public class BookListResponse {

	private List<BookResponse> bookResponse;
}