package com.employeeTry.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeTry.Repo.LeaveRequstRepo;
import com.employeeTry.entity.LeaveRequst;

@Service
public class LeaveRequstService {
	
	@Autowired
	private LeaveRequstRepo leaveRequstRepo;
	
	public LeaveRequst create(LeaveRequst leaveRequst) {
		return this.leaveRequstRepo.save(leaveRequst);
	}
	
	public List<LeaveRequst> getAll(){
		return this.leaveRequstRepo.findAll();
	}

}
