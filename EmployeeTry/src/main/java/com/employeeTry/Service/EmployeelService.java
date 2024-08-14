package com.employeeTry.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeTry.Repo.EmployeelRepo;
import com.employeeTry.entity.Employeel;


@Service
public class EmployeelService {
	 @Autowired
	    private EmployeelRepo employeeRepository;

	    public List<Employeel> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Optional<Employeel> getEmployeeById(Integer id) {
	        return employeeRepository.findById(id);
	    }

	    public Employeel saveEmployee(Employeel employee) {
	        return employeeRepository.save(employee);
	    }

	    public void deleteEmployee(Integer id) {
	        employeeRepository.deleteById(id);
	    }

}
