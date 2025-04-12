package az.book.manga.service;

import az.book.manga.model.Reader;
import az.book.manga.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    public Reader getById(Integer id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Reader create(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader update(Integer id, Reader reader) {
        reader.setId(id);
        return readerRepository.save(reader);
    }

    public void delete(Integer id) {
        readerRepository.deleteById(id);
    }
}
