package com.helloshoes.helloshoes.service;

import com.helloshoes.helloshoes.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    void deleteSupplier(String supplierId);
    SupplierDTO getSelectedSupplier(String supplierId);
    List<SupplierDTO> getAllSuppliers();
    void updateSupplier(String supplierId,SupplierDTO supplierDTO);
}
