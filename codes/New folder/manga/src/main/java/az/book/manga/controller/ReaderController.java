package az.book.manga.controller;

import az.book.manga.dto.ReaderRegisterDto;
import az.book.manga.service.ReaderService;
import az.book.manga.exception.OurRunTimeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/reader")
@CrossOrigin(origins = "*")
public class ReaderController {
	
	@Autowired
	private ReaderService service;

	@PostMapping(path = "/register")
	public String createUser(@Valid @RequestBody ReaderRegisterDto dto,BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br,"");
		}
		return service.create(dto);
	}
	
	@PostMapping(path = "/login")
	public String login(@RequestBody ReaderRegisterDto dto) {
		return service.login(dto);
	}
	
}