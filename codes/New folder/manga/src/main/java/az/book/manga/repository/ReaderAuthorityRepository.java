package az.book.manga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.book.manga.model.ReaderAuthority;

public interface ReaderAuthorityRepository extends JpaRepository<ReaderAuthority, Integer> {

    List<ReaderAuthority> findByUsername(String username);

}