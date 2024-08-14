package com.employeeTry.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeeTry.Repo.AttendanceRepo;
import com.employeeTry.entity.Attendance;
import com.employeeTry.entity.Employeel;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepo attendanceRepository;

    public List<Attendance> getAttendanceByEmployeeId(Integer employeeId) {
        return attendanceRepository.findByEmployeelId(employeeId);
    }
 
    public Attendance punchIn(Employeel employeel) {
        Attendance attendance = new Attendance();
        attendance.setEmployeel(employeel);
        attendance.setPunchIn(LocalDateTime.now());
        return attendanceRepository.save(attendance);
    }

    public Attendance punchOut(Integer attendanceId) {
        Optional<Attendance> attendanceOpt = attendanceRepository.findById(attendanceId);
        if (attendanceOpt.isPresent()) {
            Attendance attendance = attendanceOpt.get();
            attendance.setPunchOut(LocalDateTime.now());
            return attendanceRepository.save(attendance);
        }
        return null;
    }
}
