package com.employeeTry.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeTry.Repo.DasRepo;
import com.employeeTry.entity.Das;

@Service
public class DasService {
	
	@Autowired
	private DasRepo dasRepo;
	
	public Das createDas(Das das) {
		return dasRepo.save(das);
	}
	
	public List<Das> getAllDas(){
		return dasRepo.findAll();
	}

}
