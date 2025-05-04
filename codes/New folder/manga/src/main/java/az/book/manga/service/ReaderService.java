package az.book.manga.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import az.book.manga.dto.ReaderRegisterDto;
import az.book.manga.entity.User;
import az.book.manga.exception.InvalidCredentialsException;
import az.book.manga.exception.OurRuntimeException;
import az.book.manga.repository.UserRepository;
import az.book.manga.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String create(ReaderRegisterDto dto) {
        Optional<User> byUsername = userRepository.findByUsername(dto.getUsername());
        if (byUsername.isPresent()) {
            throw new OurRuntimeException(null, "Username already exists");
        }

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(user);
        return "Reader created successfully";
    }

    public String login(ReaderRegisterDto dto) {
        Optional<User> user = userRepository.findByUsername(dto.getUsername());

        if (user.isEmpty() || !passwordEncoder.matches(dto.getPassword(), user.get().getPassword())) {
            throw new InvalidCredentialsException("Username or password is incorrect");
        }

        return jwtUtil.generateToken(user.get().getUsername());
    }

    public ResponseEntity<Map<String, String>> getUserDetail(String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Map<String, String> claims = jwtUtil.extractClaims(token);
        return ResponseEntity.ok(claims);
    }
}
