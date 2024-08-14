package com.employeeTry.Controll;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fill")
public class FillCntroll {
	
	
	@PostMapping
	public ResponseEntity<?>uplodeFill(){
		return ResponseEntity.ok("uplode succsecc");
	}

}
