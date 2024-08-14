package com.employeeTry.Controll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.employeeTry.Service.EmployeeService;
import com.employeeTry.Service.FileService;
import com.employeeTry.dto.FileResponse;

import com.employeeTry.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/employee")
//@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)

public class EmployeeControll {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Value("${project.image}")
	private String path;
	
	private Logger logger=LoggerFactory.getLogger(EmployeeControll.class);
	
	
	@PostMapping("/")
	public ResponseEntity<?> addImage(@RequestParam("userData") String image,@RequestParam("file") MultipartFile file  ) throws JsonMappingException, JsonProcessingException{
		logger.info("file name {}",file.getOriginalFilename());
		logger.info("image:{}",image);
		
		Employee employee=this.objectMapper.readValue(image, Employee.class);
		employee.setZName(file.getOriginalFilename());
		Employee employee2=this.employeeService.createEmployee(employee);
		
		String fileName;
		try {
			fileName = this.fileService.uplodeImage(path, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<FileResponse>(new FileResponse(null,"Image is successfully not uplodeed !!"), HttpStatus.OK);

		}
//		Employee employee=this.objectMapper.readValue(image, Employee.class);
//		employee.setZName(fileName);
//		Employee employee2=this.employeeService.createEmployee(employee);
		
		
		
		return new ResponseEntity<FileResponse>(new FileResponse(fileName,"Image is successfully uplodeed !!"), HttpStatus.OK);
	}
	
	
//	@PostMapping("/")
//	public ResponseEntity<Employee> createCategory(@RequestBody Employee employee){
//		Employee createEmployee=this.employeeService.createEmployee(employee);
//		return new ResponseEntity<Employee>(createEmployee,HttpStatus.CREATED);
//
//
//	}
	//get
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(this.employeeService.getAllEmployee());
	}
//	@GetMapping("/count")
//    public Map<String, Long> getEmployeeCount() {
//        Map<String, Long> counts = new HashMap<>();
//        counts.put("male", employeeService.getMaleEmployeeCount());
//        counts.put("female", employeeService.getFemaleEmployeeCount());
//        return counts;
//    }
	
	@GetMapping("/countm")
	public ResponseEntity<Long> countByMale(){
		return ResponseEntity.ok(this.employeeService.getMaleEmployeeCount());

	}
	//methode to serve file
	@GetMapping(value = "/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downlodeImage(@PathVariable ("imageName") String imageName,
			HttpServletResponse response) throws IOException {
		
		InputStream resource=this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());}
	
	

}
