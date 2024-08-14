package com.employeeTry.Repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employeeTry.entity.Don;

public interface DonRepo extends JpaRepository<Don, Long> {
	 List<Don> findByDateBetween(LocalDate startDate, LocalDate endDate);
	  Don findByEmployeeNameAndDate(String employeeName, LocalDate date);
	  @Query("SELECT COUNT(a) FROM Don a WHERE a.date BETWEEN :startDate AND :endDate")
	    long countAttendanceForMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	  @Query("SELECT FUNCTION('MONTH', a.date) AS month, COUNT(a) AS count " +
	           "FROM Don a " +
	           "WHERE a.date BETWEEN :startDate AND :endDate " +
	           "GROUP BY FUNCTION('MONTH', a.date)")
	    Map<Integer, Long> countAttendanceByMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
//	  @Query("SELECT a FROM Don a WHERE a.employeeId = :employeeId AND a.date = :date")
//	  Optional<Don> findByEmployeeIdAndDate(@Param("employeeId") Long employeeId, @Param("date") LocalDate date);
//	  @Query("SELECT a FROM Don a WHERE a.employeeId = :employeeId AND a.date = :date")
//	  List<Don> findAttendanceByEmployeeAndDate(@Param("employeeId") Long employeeId, @Param("date") LocalDate date);


	

}
