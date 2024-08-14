package com.employeeTry.Controll;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeTry.Service.DonService;
import com.employeeTry.entity.Don;

@RestController
@RequestMapping("/api/attendance")
public class DonControll {
	 @Autowired
	    private DonService attendanceService;

	    @GetMapping("/{year}/{month}")
	    public List<Don> getAttendanceForMonth(@PathVariable int year, @PathVariable int month) {
	        return attendanceService.getAttendanceForMonth(year, month);
	    }
	    
	    @PostMapping
	    public Don addAttendance(@RequestBody Don attendance) {
	        return attendanceService.saveAttendance(attendance);
	    }
	    @PostMapping("/punch-in")
	    public ResponseEntity<Don> punchIn(@RequestParam String employeeName, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
	        Don attendance = attendanceService.punchIn(employeeName, date);
	        return ResponseEntity.ok(attendance);
	    }

	    @PostMapping("/punch-out")
	    public ResponseEntity<Don> punchOut(@RequestParam String employeeName, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
	        Don attendance = attendanceService.punchOut(employeeName, date);
	        return attendance != null ? ResponseEntity.ok(attendance) : ResponseEntity.notFound().build();
	    }
	    @GetMapping("/count")
	    public long countAttendanceForMonth(@RequestParam int year, @RequestParam int month) {
	        return attendanceService.countAttendanceForMonth(year, month);
	    }
	    @GetMapping("/monthly-count")
	    public Map<Month, Long> getMonthlyAttendanceCount(@RequestParam int year) {
	        return attendanceService.countAttendanceForYear(year);
	    }
	    @GetMapping("/monthly-count-current-year")
	    public Map<Month, Long> getMonthlyAttendanceCountForCurrentYear() {
	        return attendanceService.countAttendanceForCurrentYear();
	    }
	    
//	    // Endpoint to get attendance for a specific employee on a given date
//	    @GetMapping("/employee/{employeeId}/date/{date}")
//	    public ResponseEntity<?> getAttendanceForEmployeeOnDate(
//	            @PathVariable Long employeeId, @PathVariable String date) {
//	        
//	        // Parse the date
//	        LocalDate parsedDate = LocalDate.parse(date);
//	        
//	        // Retrieve the attendance list for the given employee and date
//	        List<Don> attendances = attendanceService.findAttendanceForEmployeeAndDate(employeeId, parsedDate);
//	        
//	        if (attendances.isEmpty()) {
//	            return ResponseEntity.notFound().build();  // No attendance found
//	        } else if (attendances.size() == 1) {
//	            return ResponseEntity.ok(attendances.get(0));  // Only one record found
//	        } else {
//	            // Multiple results found, return the list
//	            return ResponseEntity.ok(attendances);  // Multiple attendance records found
//	        }
//	    }

}
