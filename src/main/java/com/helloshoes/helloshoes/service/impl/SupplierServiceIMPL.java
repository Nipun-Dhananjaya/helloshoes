package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dao.SupplerRepo;
import com.helloshoes.helloshoes.dto.SupplierDTO;
import com.helloshoes.helloshoes.service.SupplierService;
import com.helloshoes.helloshoes.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceIMPL implements SupplierService {
    private final SupplerRepo repo;
    private final Mapping mapping;
    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        return mapping.toSupplierDTO(repo.save(mapping.toSupplier(supplierDTO)));
    }

    @Override
    public boolean deleteSupplier(String supplierId) {
        if (repo.existsById(supplierId)) {
            repo.deleteById(supplierId);
            return true;
        }
        return false;
    }

    @Override
    public SupplierDTO getSelectedSupplier(String supplierId) {
        return mapping.toSupplierDTO(repo.getReferenceById(supplierId));
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return mapping.toSupplierDTOList(repo.findAll());
    }

    @Override
    public SupplierDTO updateSupplier(String supplierId, SupplierDTO supplierDTO) {
        SupplierDTO supDTO = mapping.toSupplierDTO(repo.getReferenceById(supplierId));
        supDTO.setSupName(supplierDTO.getSupName());
        supDTO.setCategory(supplierDTO.getCategory());
        supDTO.setAddress(supplierDTO.getAddress());
        supDTO.setContactOne(supplierDTO.getContactOne());
        supDTO.setContactTwo(supplierDTO.getContactTwo());
        supDTO.setEmail(supplierDTO.getEmail());
        supDTO.setItems(supplierDTO.getItems());
        repo.save(mapping.toSupplier(supDTO));
        return supDTO;
    }
}
