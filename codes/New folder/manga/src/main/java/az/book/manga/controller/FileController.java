package az.book.manga.controller;


import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@GetMapping("/download/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> seveFile(@PathVariable String filename) throws Exception {

		Resource file = loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
				.body(file);
	}

	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Path load(String filename) {
		Path rootLocation = Paths.get()"C:/Downloads/TestSubject");
		return rootLocation.resolve(filename);
	}
}