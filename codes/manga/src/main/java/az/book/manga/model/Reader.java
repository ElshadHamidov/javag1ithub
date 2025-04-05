package az.book.manga.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name boş ola bilməz")
    private String name;

    @Min(value = 0, message = "Yaş düzgün daxil edilməyib")
    private int age;

    @Email(message = "Email düzgün deyil")
    private String email;
}
