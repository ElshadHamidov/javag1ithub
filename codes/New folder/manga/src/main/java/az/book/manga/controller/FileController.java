package az.book.manga.controller;


import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/files")
@CrossOrigin(origins = "*")
public class FileController {

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void upload(@RequestParam(name = "file") MultipartFile file) throws Throwable {
		
		//Get stream from file
		InputStream stream = file.getInputStream();
		
		//home.png
		//Get file original name
		String originalFilename = file.getOriginalFilename();
		
		//Create random file name
		UUID uuid = UUID.randomUUID();
		String randomName = uuid.toString(); //rtwerwe-wrhejrh.png
		
		//Get file name without extension
		String originalFileNameWithoutExtension = originalFilename.substring(0, originalFilename.lastIndexOf("."));
		
		//Replace original file name to random file name
		String randomFileName = originalFilename.replace(originalFileNameWithoutExtension, randomName);
		
		//Create folder
		File folder = new File("C:/Downloads/TestSubject");
		if (!folder.exists()) {
			folder.mkdir();
		}
		
		//Save to disk random file name
		Files.copy(stream, Paths.get("C:/Downloads/TestSubject" + "/" + randomFileName), StandardCopyOption.REPLACE_EXISTING);
		
		
	}
}