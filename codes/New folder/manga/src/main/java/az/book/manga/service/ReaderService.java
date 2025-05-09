package az.book.manga.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import az.book.manga.dto.ReaderRegisterDto;
import az.book.manga.model.Reader;
import az.book.manga.exception.InvalidCredentialsException;
import az.book.manga.exception.OurRuntimeException;
import az.book.manga.repository.BookRepository;
import az.book.manga.repository.ReaderRepository;
import az.book.manga.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReaderService {

	private final ReaderRepository readerRepository;
	private final BookRepository bookRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	public String create(ReaderRegisterDto dto) {
		Optional<Reader> byUsername = readerRepository.findByUsername(dto.getUsername());
		if (byUsername.isPresent()) {
			throw new OurRuntimeException(null, "Username already exists");
		}

		String encode = passwordEncoder.encode(dto.getPassword());

		Reader reader = new Reader();
		reader.setFirstName(dto.getFirstName());
		reader.setLastName(dto.getLastName());
		reader.setUsername(dto.getUsername());
		reader.setEmail(dto.getEmail());
		reader.setPassword(encode);
		readerRepository.save(reader);
		return "Reader created successfully";
	}

	public String login(ReaderRegisterDto dto) {
		Optional<Reader> reader = readerRepository.findByUsername(dto.getUsername());

		if (!reader.isPresent() || !passwordEncoder.matches(dto.getPassword(), reader.get().getPassword())) {
			throw new InvalidCredentialsException("Username or password incorrect");
		}

		return jwtUtil.generateToken(
			reader.get().getUsername(),
			reader.get().getFirstName(),
			reader.get().getLastName(),
			reader.get().getEmail()
		);
	}

	public ResponseEntity<Map<String, String>> getReaderDetail(String token) {
		if (token.startsWith("Bearer")) {
			token = token.substring(7);
		}
		Map<String, String> claims = jwtUtil.extractClaims(token);
		return ResponseEntity.ok(claims);
	}

	public void delete(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "ID is required");
		}
		Optional<Reader> found = readerRepository.findById(id);
		if (found.isPresent()) {
			Reader reader = found.get();
			readerRepository.deleteById(id);
			bookRepository.deleteReaderBooks(reader.getId());
		} else {
			throw new OurRuntimeException(null, "Reader not found");
		}
	}
}
