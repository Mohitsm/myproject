package com.employeeTry.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeTry.entity.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
