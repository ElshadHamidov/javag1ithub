package az.book.manga.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.book.manga.dto.ReaderRegisterDto;
import az.book.manga.exception.OurRuntimeException;
import az.book.manga.service.ReaderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/reader")
@CrossOrigin(origins = "*")
public class ReaderController {

    @Autowired
    private ReaderService service;

    @PostMapping(path = "/register")
    public String createReader(@Valid @RequestBody ReaderRegisterDto dto, BindingResult br) {
        if (br.hasErrors()) {
            throw new OurRuntimeException(br, "");
        }
        return service.create(dto);
    }

    @PostMapping(path = "/login")
    public String login(@RequestBody ReaderRegisterDto dto) {
        return service.login(dto);
    }

    @GetMapping(path = "/profile")
    public ResponseEntity<Map<String, String>> getReaderDetails(@RequestHeader("Authorization") String token) {
        return service.getUserDetail(token);
    }
}
