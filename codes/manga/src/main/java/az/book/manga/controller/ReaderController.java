package az.book.manga.controller;

import az.book.manga.exception.OurRuntimeException;
import az.book.manga.model.Reader;
import az.book.manga.service.ReaderService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReaderController {

    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping
    public List<Reader> getAllReaders() {
        return readerService.getAll();
    }

    @GetMapping("/{id}")
    public Reader getReaderById(@PathVariable Long id) {
        return readerService.getById(id).orElse(null);
    }

    @PostMapping
    public Reader createReader(@Valid @RequestBody Reader reader, BindingResult br) {
        if (br.hasErrors()) throw new OurRuntimeException(br);
        return readerService.save(reader);
    }

    @PutMapping("/{id}")
    public Reader updateReader(@PathVariable Long id, @Valid @RequestBody Reader reader, BindingResult br) {
        if (br.hasErrors()) throw new OurRuntimeException(br);
        return readerService.update(id, reader);
    }

    @DeleteMapping("/{id}")
    public void deleteReader(@PathVariable Long id) {
        readerService.delete(id);
    }
}
