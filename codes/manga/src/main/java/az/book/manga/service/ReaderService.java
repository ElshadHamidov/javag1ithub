package az.book.manga.service;

import az.book.manga.model.Reader;
import az.book.manga.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    public Optional<Reader> getById(Long id) {
        return readerRepository.findById(id);
    }

    public Reader save(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader update(Long id, Reader reader) {
        reader.setId(id);
        return readerRepository.save(reader);
    }

    public void delete(Long id) {
        readerRepository.deleteById(id);
    }
}
