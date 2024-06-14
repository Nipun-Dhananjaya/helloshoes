package com.helloshoes.helloshoes.controller;

import com.helloshoes.helloshoes.dto.EmployeeDTO;
import com.helloshoes.helloshoes.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employee) {
        System.out.println(employee.toString());
        return employeeService.saveEmployee(employee);
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empCode}")
    public EmployeeDTO getEmployeeById(@PathVariable String empCode) {
        return employeeService.getSelectedEmployee(empCode);
    }

    @PutMapping("/{empCode}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable String empCode, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(empCode, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{empCode}")
    public void deleteEmployee(@PathVariable String empCode) {
        employeeService.deleteEmployee(empCode);
    }
}

