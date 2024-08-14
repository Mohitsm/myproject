package com.employeeTry.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeTry.entity.LeaveRequst;

public interface LeaveRequstRepo extends JpaRepository<LeaveRequst, Integer> {

}
