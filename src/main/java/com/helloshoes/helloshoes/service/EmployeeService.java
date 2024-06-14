package com.helloshoes.helloshoes.service;

import com.helloshoes.helloshoes.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(String employeeId);
    EmployeeDTO getSelectedEmployee(String employeeId);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO);
}
