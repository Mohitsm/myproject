package com.employeeTry.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.employeeTry.entity.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {
    List<Attendance> findByEmployeelId(Integer employeelId);
}
