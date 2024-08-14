package com.employeeTry.Controll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.employeeTry.Service.DocumentService;

import java.io.IOException;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

	 @Autowired
	    private DocumentService documentService;

	    @PostMapping("/")
	    public ResponseEntity<String> uploadDocuments(
	            @RequestParam("matric") MultipartFile matric,
	            @RequestParam("inter") MultipartFile inter,
	            @RequestParam("graduation") MultipartFile graduation,
	            @RequestParam("pg") MultipartFile pg,
	            @RequestParam("aadhar") MultipartFile aadhar,
	            @RequestParam("pan") MultipartFile pan,
	            @RequestParam("dl") MultipartFile dl,
	            @RequestParam("employeeId") String employeeId
	    ) {
	        try {
	            documentService.saveDocumentDetails(matric, inter, graduation, pg, aadhar, pan, dl, employeeId);
	            return new ResponseEntity<>("Files uploaded and details saved successfully!", HttpStatus.OK);
	        } catch (IOException e) {
	            return new ResponseEntity<>("File upload failed!", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
