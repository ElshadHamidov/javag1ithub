package az.book.manga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    private Integer id;
    private String title;
    private String author;
    private Integer year;
    private Integer readerId;
}
