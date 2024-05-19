package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dao.EmployeeRepo;
import com.helloshoes.helloshoes.dto.EmployeeDTO;
import com.helloshoes.helloshoes.service.EmployeeService;
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
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return mapping.toEmployeeDTO(repo.save(mapping.toEmployee(employeeDTO)));
    }

    @Override
    public void deleteEmployee(String employeeId) {
        EmployeeDTO employeeDTO = mapping.toEmployeeDTO(repo.getReferenceById(employeeId));
        repo.delete(mapping.toEmployee(employeeDTO));
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String employeeId) {
        return mapping.toEmployeeDTO(repo.getReferenceById(employeeId));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return mapping.toEmployeeDTOList(repo.findAll());
    }

    @Override
    public void updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        EmployeeDTO empDTO = mapping.toEmployeeDTO(repo.getReferenceById(employeeId));
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
    }
}
