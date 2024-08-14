package com.employeeTry.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeTry.Repo.EmployeeRepo;
import com.employeeTry.Service.EmployeeService;
import com.employeeTry.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		Employee createEmployee=this.employeeRepo.save(employee);
		return createEmployee;
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
	   List<Employee> employees=this.employeeRepo.findAll();
	   List<Employee> getAllEmployees=employees.stream().map(employee->{
		   Employee newEmployee=new Employee();
		   newEmployee.setEmployeeId(employee.getEmployeeId());
		   newEmployee.setName(employee.getName());
		   newEmployee.setUserName(employee.getUserName());
		   newEmployee.setEmail(employee.getEmail());
		   newEmployee.setGender(employee.getGender());
		   newEmployee.setCategory(employee.getCategory());
		   newEmployee.setZName(employee.getZName());
		   return newEmployee;
	   }).collect(Collectors.toList());
		return getAllEmployees;
	}
	 public long getMaleEmployeeCount() {
	        return employeeRepo.countMaleEmployees();
	    }

	    public long getFemaleEmployeeCount() {
	        return employeeRepo.countFemaleEmployees();
	    }

}
