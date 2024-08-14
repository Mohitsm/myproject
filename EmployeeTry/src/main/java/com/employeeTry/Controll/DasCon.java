package com.employeeTry.Controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeTry.Service.DasService;
import com.employeeTry.entity.Das;

@RequestMapping("/api")
@RestController
public class DasCon {
	
	@Autowired
	private DasService dasService;
	
	
	@PostMapping
	public Das createDas(@RequestBody Das  das) {
		return dasService.createDas(das);
	}
	
	@GetMapping
	public List<Das> getAllDas(){
		return dasService.getAllDas();
	}

}
