package az.book.manga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import az.book.manga.model.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    Optional<Reader> findByUsername(String username);

    Reader getReaderByUsername(String username);
}
