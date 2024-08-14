package com.employeeTry.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeTry.entity.Employeel;

public interface EmployeelRepo extends JpaRepository<Employeel, Integer> {

}
