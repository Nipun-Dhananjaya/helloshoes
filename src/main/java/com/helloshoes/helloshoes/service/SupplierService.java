package com.helloshoes.helloshoes.service;

import com.helloshoes.helloshoes.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    boolean deleteSupplier(String supplierId);
    SupplierDTO getSelectedSupplier(String supplierId);
    List<SupplierDTO> getAllSuppliers();
    SupplierDTO updateSupplier(String supplierId, SupplierDTO supplierDTO);
}
