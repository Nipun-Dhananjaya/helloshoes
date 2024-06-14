package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dao.EmployeeRepo;
import com.helloshoes.helloshoes.dto.EmployeeDTO;
import com.helloshoes.helloshoes.dto.UserDTO;
import com.helloshoes.helloshoes.service.EmployeeService;
import com.helloshoes.helloshoes.service.UserService;
import com.helloshoes.helloshoes.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeRepo repo;
    private final Mapping mapping;
    private final UserService userService;
    @Override
    @Transactional
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO.toString());
        if (employeeDTO.getEmpCode() == null || employeeDTO.getEmpCode().isEmpty()) {
            throw new IllegalArgumentException("Employee empCode must be provided");
        }
        if (employeeDTO.getUser() == null && employeeDTO.getEmail() != null) {
            UserDTO user = userService.getSelectedUser(employeeDTO.getEmail());
            employeeDTO.setUser(user);
            return mapping.toEmployeeDTO(repo.save(mapping.toEmployee(employeeDTO)));
        }else{
            return mapping.toEmployeeDTO(repo.save(mapping.toEmployee(employeeDTO)));
        }
    }

    @Override
    @Transactional
    public void deleteEmployee(String empCode) {
        EmployeeDTO employeeDTO = mapping.toEmployeeDTO(repo.getReferenceById(empCode));
        repo.delete(mapping.toEmployee(employeeDTO));
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String empCode) {
        return mapping.toEmployeeDTO(repo.getReferenceById(empCode));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOS = mapping.toEmployeeDTOList(repo.findAll());
        return employeeDTOS;
    }

    @Override
    @Transactional
    public EmployeeDTO updateEmployee(String empCode, EmployeeDTO employeeDTO) {
        EmployeeDTO empDTO = mapping.toEmployeeDTO(repo.getReferenceById(empCode));
        empDTO.setEmpName(employeeDTO.getEmpName());
        empDTO.setJoinedDate(employeeDTO.getJoinedDate());
        empDTO.setStatus(employeeDTO.getStatus());
        empDTO.setDesignation(employeeDTO.getDesignation());
        empDTO.setAccessRole(employeeDTO.getAccessRole());
        empDTO.setDob(employeeDTO.getDob());
        empDTO.setBranch(employeeDTO.getBranch());
        empDTO.setAddress(employeeDTO.getAddress());
        empDTO.setContact(employeeDTO.getContact());
        empDTO.setEmail(employeeDTO.getEmail());
        empDTO.setGuardian(employeeDTO.getGuardian());
        empDTO.setGuardianCont(employeeDTO.getGuardianCont());
        repo.save(mapping.toEmployee(empDTO));
        return empDTO;
    }
}

