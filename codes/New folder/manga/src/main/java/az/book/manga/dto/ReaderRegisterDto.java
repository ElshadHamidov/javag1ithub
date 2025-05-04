package az.book.manga.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderRegisterDto {
	
	@Size(min= 2, max=50, message = "min 2 max 50 simvol olmalidir")
	private String firstName;
	
	@Size(min= 2, max=50, message = "min 2 max 50 simvol olmalidir")
	private String lastName;
	private String username;
	private String password; 
	private String email;
}