package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dto.EmployeeDTO;
import com.helloshoes.helloshoes.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public void deleteEmployee(String employeeId) {

    }

    @Override
    public EmployeeDTO getSelectedEmployee(String employeeId) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return null;
    }

    @Override
    public void updateEmployee(String employeeId, EmployeeDTO employeeDTO) {

    }
}
