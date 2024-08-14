package com.employeeTry.Controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employeeTry.Service.AttendanceService;
import com.employeeTry.entity.Attendance;
import com.employeeTry.entity.Employeel;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/punchIn")
    public ResponseEntity<Integer> punchIn(@RequestBody Employeel employeel) {
        Attendance attendance = attendanceService.punchIn(employeel);
        return ResponseEntity.ok(attendance.getId());
    }

    @PostMapping("/punchOut/{id}")
    public ResponseEntity<String> punchOut(@PathVariable Integer id) {
        Attendance attendance = attendanceService.punchOut(id);
        if (attendance != null) {
            return ResponseEntity.ok("Punched out successfully with ID: " + attendance.getId());
        } else {
            return ResponseEntity.badRequest().body("Attendance record not found");
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Attendance>> getAttendanceByEmployeeId(@PathVariable Integer employeeId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByEmployeeId(employeeId);
        return ResponseEntity.ok(attendanceList);
    }
//    @PostMapping("/punchOut/{attendanceId}")
//    public ResponseEntity<String> punchOut(@PathVariable Long attendanceId, @RequestBody Map<String, Object> requestData) {
//        int timer = (int) requestData.get("timer");
//        boolean success = attendanceService.punchOut(attendanceId, timer);
//        if (success) {
//            return ResponseEntity.ok("Punched out successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Punch out failed.");
//        }
//    }
}
