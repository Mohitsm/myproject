package com.employeeTry.Controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeTry.Service.LeaveRequstService;
import com.employeeTry.entity.LeaveRequst;

@RequestMapping("/api")
@RestController
public class LeaveRequstControll {
	
	@Autowired
	private LeaveRequstService leaveRequstService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<LeaveRequst> create(@RequestBody LeaveRequst leaveRequst){
		
		LeaveRequst leaveRequst2=this.leaveRequstService.create(leaveRequst);
		return new ResponseEntity<LeaveRequst>(leaveRequst2,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<LeaveRequst>> getAll(){
		return ResponseEntity.ok(this.leaveRequstService.getAll());
	}

}
