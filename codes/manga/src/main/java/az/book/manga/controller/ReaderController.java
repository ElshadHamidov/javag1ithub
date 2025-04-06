package az.book.manga.controller;

import az.book.manga.model.Reader;
import az.book.manga.repository.ReaderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReaderController {
    private final ReaderRepository readerRepository;

    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @GetMapping
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reader getReader(@PathVariable Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Reader createReader(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }

    @PutMapping("/{id}")
    public Reader updateReader(@PathVariable Long id, @RequestBody Reader reader) {
        reader.setId(id);
        return readerRepository.save(reader);
    }

    @DeleteMapping("/{id}")
    public void deleteReader(@PathVariable Long id) {
        readerRepository.deleteById(id);
    }
}
