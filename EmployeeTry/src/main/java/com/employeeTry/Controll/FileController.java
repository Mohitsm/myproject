package com.employeeTry.Controll;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employeeTry.Service.FileService;
import com.employeeTry.dto.FileResponse;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/file")

public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/uplode")
	public ResponseEntity<FileResponse> fileUplode(@RequestParam("image") MultipartFile image){
		String fileName;
		try {
			fileName = this.fileService.uplodeImage(path, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<FileResponse>(new FileResponse(null,"Image is successfully not uplodeed !!"), HttpStatus.OK);

		}
		
		return new ResponseEntity<FileResponse>(new FileResponse(fileName,"Image is successfully uplodeed !!"), HttpStatus.OK);
		
		}
	//methode to serve file
	@GetMapping(value = "/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downlodeImage(@PathVariable ("imageName") String imageName,
			HttpServletResponse response) throws IOException {
		
		InputStream resource=this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}

}
