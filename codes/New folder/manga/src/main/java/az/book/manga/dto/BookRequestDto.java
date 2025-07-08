package az.book.manga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Book Request Dto", description = "Kitab məlumatlarını qəbul edən DTO")
@ToString
public class BookRequestDto {
    private Integer id;
    private String title;
    private String genre;
    private Integer rating;
    private Integer userId;
}
