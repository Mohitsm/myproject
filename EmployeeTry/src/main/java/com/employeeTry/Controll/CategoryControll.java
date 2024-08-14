package com.employeeTry.Controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeTry.Service.CategoryService;
import com.employeeTry.entity.Category;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)

public class CategoryControll {
	
	@Autowired
	private CategoryService categoryService;
	
	//create Category
	@PostMapping("/")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		Category category2=this.categoryService.createCategory(category);
		return new ResponseEntity<Category>(category2,HttpStatus.CREATED);


	}
	//get
	@GetMapping("/")
	public ResponseEntity<List<Category>> getAllCategory(){
		return ResponseEntity.ok(this.categoryService.getAllCategory());
	}
	


}
