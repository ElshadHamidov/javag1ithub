package az.azerbook.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.azerbook.reader.entity.ReaderEntity;
import az.azerbook.reader.repository.ReaderRepository;
import az.azerbook.reader.response.ReaderListResponse;

@RestController
@RequestMapping(path = "/readers")
@CrossOrigin(origins = "*")
public class ReaderController {

	@Autowired
	private ReaderRepository readerRepository;
	
	@GetMapping(path = "/getAll")
	public ReaderListResponse getReader() {
		ReaderListResponse resp = new ReaderListResponse();
		
		List<ReaderEntity> readers = readerRepository.findAll();
		
		resp.setReaderResponse(readers);
		
		return resp;
	}
}