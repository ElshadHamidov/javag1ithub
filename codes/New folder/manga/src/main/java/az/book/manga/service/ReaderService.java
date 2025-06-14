package az.book.manga.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import az.book.manga.dto.ReaderRegisterDto;
import az.book.manga.model.Authorities;
import az.book.manga.exception.InvalidCredentialsException;
import az.book.manga.exception.OurRuntimeException;
import az.book.manga.repository.ReaderRepository;
import az.book.manga.repository.BookRepository;
import az.book.manga.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final BookRepository bookRepository;
    private final PasswordEncoder passwordEncoder;
    private final ReaderRepository authorityRepository;
    private final JwtUtil jwtUtil;

    public String login(ReaderRegisterDto dto) {
        Optional<Authorities> authority = authorityRepository.findByUsername(dto.getUsername());

    @Autowired
        private ModelMapper modelMapper;if(!authority.isPresent()||!passwordEncoder.matches(dto.getPassword(),authority.get().getPassword()))
    {
        throw new InvalidCredentialsException("Username or password incorrect");
    }
    List<String> authorityList = authorityRepository.findByUsername(dto.getUsername()).stream()
            .map(Authorities::getAuthority)
            .collect(Collectors.toList());

    return jwtUtil.generateToken(dto.getUsername(),dto.getFirstName(),dto.getLastName(),dto.getEmail(),authorityList);
    }
    modelMapper.map(dto,user);

    public ResponseEntity<Map<String, Object>> getReaderDetail(String token) {
        if (token.startsWith("Bearer")) {
            token = token.substring(7);
        }
        Map<String, Object> claims = jwtUtil.extractClaims(token);
        return ResponseEntity.ok(claims);
    }

    public void deleteReader(Integer id) {
        if (id == null || id <= 0) {
            throw new OurRuntimeException(null, "ID is invalid");
        }

        bookRepository.deleteBooksByReaderId(id);
    }
}
