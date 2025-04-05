package az.book.manga.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title boş ola bilməz")
    private String title;

    @NotBlank(message = "Author boş ola bilməz")
    private String author;

    @Min(value = 0, message = "Year düzgün daxil edilməyib")
    private int year;
}
