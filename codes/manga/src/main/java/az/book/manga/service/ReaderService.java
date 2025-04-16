package az.book.manga.service;

import az.book.manga.dto.ReaderRegisterDto;
import az.book.manga.model.Reader;
import az.book.manga.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(ReaderRegisterDto dto) {
        Reader reader = new Reader();
        reader.setName(dto.getName());
        reader.setAge(dto.getAge());
        reader.setEmail(dto.getEmail());
        reader.setPassword(passwordEncoder.encode(dto.getPassword()));

        readerRepository.save(reader);
        return "Reader registered successfully";
    }
}
