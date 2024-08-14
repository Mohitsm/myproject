package com.employeeTry.Service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	String uplodeImage(String path,MultipartFile file)throws IOException;
	
	InputStream getResource(String path,String fileName)throws FileNotFoundException;
	
    FileInputStream getResources(String path, String fileName) throws IOException;

}