package com.employeeTry.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeTry.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	 @Query("SELECT COUNT(e) FROM Employee e WHERE e.gender = 'male'")
	    long countMaleEmployees();

	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.gender = 'female'")
	    long countFemaleEmployees();

}
