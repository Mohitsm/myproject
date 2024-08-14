package com.employeeTry.Service;

import java.util.List;

import com.employeeTry.entity.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee,Integer employeeId);
	void deleteEmployee(Integer employeeId);
	Employee getEmployeeById(Integer employeeId);
	List<Employee> getAllEmployee();
	 public long getMaleEmployeeCount();

	    public long getFemaleEmployeeCount();

}
