package com.employeeTry.Controll;

import com.employeeTry.Service.EmployeelService;
import com.employeeTry.entity.Employeel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeelController {
    @Autowired
    private EmployeelService employeeService;

    @GetMapping
    public List<Employeel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employeel> getEmployeeById(@PathVariable Integer id) {
        Optional<Employeel> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Employeel saveEmployee(@RequestBody Employeel employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}