package com.employeeTry.ServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employeeTry.Service.FileService;



@Service
public class FileServiceImpl implements FileService {
	
	@Value("${project.image}")
	private String path;

	@Override
	public String uplodeImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		//file name
		String name=file.getOriginalFilename();
		//ransam id genreted
		String randomId=UUID.randomUUID().toString();
		String fileName1=randomId.concat(name).substring(name.lastIndexOf("."));
		
		//full path
		String filePath=path+ File.separator+name;
		//create folder if not createed
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		//file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String fullPath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullPath);
		return is;
	}
	@Override
    public FileInputStream getResources(String path, String fileName) throws IOException {
        String fullPath = path + File.separator + fileName;
        return new FileInputStream(new File(fullPath));
    }
	public File getResources(String fileName) throws FileNotFoundException {
	    String filePath = "image/" + fileName;
	    // Log the file path
	    System.out.println("Attempting to access file: " + filePath);
	    File file = new File(filePath);
	    if (!file.exists()) {
	        throw new FileNotFoundException(filePath + " (The system cannot find the path specified)");
	    }
	    return file;
	}


}

