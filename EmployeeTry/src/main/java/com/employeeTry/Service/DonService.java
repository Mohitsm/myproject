package com.employeeTry.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeTry.Repo.DonRepo;
import com.employeeTry.entity.Don;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NonUniqueResultException;

@Service
public class DonService {
	@Autowired
    private DonRepo attendanceRepository;

    public List<Don> getAttendanceForMonth(int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        return attendanceRepository.findByDateBetween(startDate, endDate);
    }
    
    public Don saveAttendance(Don attendance) {
        return attendanceRepository.save(attendance);
    }
    public Don punchIn(String employeeName, LocalDate date) {
    	Don attendance = attendanceRepository.findByEmployeeNameAndDate(employeeName, date);
        if (attendance == null) {
            attendance = new Don();
            attendance.setEmployeeName(employeeName);
            attendance.setDate(date);
        }
        attendance.setPunchInTime(LocalDateTime.now());
        attendance.setPresent(true);
        return attendanceRepository.save(attendance);
    }

    public Don punchOut(String employeeName, LocalDate date) {
    	Don attendance = attendanceRepository.findByEmployeeNameAndDate(employeeName, date);
        if (attendance != null) {
            attendance.setPunchOutTime(LocalDateTime.now());
            return attendanceRepository.save(attendance);
        }
        return null; // or handle the case where the punch-out record is not found
        
        

}
    public long countAttendanceForMonth(int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
        return attendanceRepository.countAttendanceForMonth(startDate, endDate);
    }
    public Map<Month, Long> countAttendanceForYear(int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        Map<Integer, Long> result = attendanceRepository.countAttendanceByMonth(startDate, endDate);

        // Convert to a map with Month enum
        Map<Month, Long> monthlyAttendance = new HashMap<>();
        for (Month month : Month.values()) {
            monthlyAttendance.put(month, result.getOrDefault(month.getValue(), 0L));
        }
        return monthlyAttendance;
    }
    public Map<Month, Long> countAttendanceForCurrentYear() {
        int currentYear = LocalDate.now().getYear();
        LocalDate startDate = LocalDate.of(currentYear, 1, 1);
        LocalDate endDate = LocalDate.of(currentYear, 12, 31);
        Map<Integer, Long> result = attendanceRepository.countAttendanceByMonth(startDate, endDate);

        // Convert to a map with Month enum
        Map<Month, Long> monthlyAttendance = new HashMap<>();
        for (Month month : Month.values()) {
            monthlyAttendance.put(month, result.getOrDefault(month.getValue(), 0L));
        }
        return monthlyAttendance;
    }
//    public Don getAttendanceForEmployee(Long employeeId, LocalDate date) {
//        List<Don> attendances = attendanceRepository.findAttendanceByEmployeeAndDate(employeeId, date);
//        if (attendances.size() == 1) {
//            return attendances.get(0);
//        } else if (attendances.isEmpty()) {
//            throw new EntityNotFoundException("Attendance not found for the given employee and date.");
//        } else {
//            throw new NonUniqueResultException("More than one attendance record found for the given employee and date.");
//        }
//    }
//    public List<Don> findAttendanceForEmployeeAndDate(Long employeeId, LocalDate date) {
//        return attendanceRepository.findAttendanceByEmployeeAndDate(employeeId, date);
//    }

}
