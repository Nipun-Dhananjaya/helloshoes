package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dto.SupplierDTO;
import com.helloshoes.helloshoes.service.SupplierService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceIMPL implements SupplierService {
    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public void deleteSupplier(String supplierId) {

    }

    @Override
    public SupplierDTO getSelectedSupplier(String supplierId) {
        return null;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return null;
    }

    @Override
    public void updateEmployee(String employeeId, SupplierDTO supplierDTO) {

    }
}
