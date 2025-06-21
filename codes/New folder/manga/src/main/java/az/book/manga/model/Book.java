package az.book.manga.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;
    private int year;

    @OneToOne(mappedBy = "book")
	private BookDetail bookDetail;
	
	@ManyToOne
	private Category category;
	
	@ManyToMany(mappedBy = "books")
	private List<Reader> viewers;
}
