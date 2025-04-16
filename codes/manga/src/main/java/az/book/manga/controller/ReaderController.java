package az.book.manga.controller;

import az.book.manga.dto.ReaderRegisterDto;
import az.book.manga.service.ReaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid ReaderRegisterDto dto) {
        String result = readerService.register(dto);
        return ResponseEntity.ok(result);
    }
}
