package com.helloshoes.helloshoes.controller;

import com.helloshoes.helloshoes.dto.SupplierDTO;
import com.helloshoes.helloshoes.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @GetMapping
    public List<SupplierDTO> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{supCode}")
    public SupplierDTO getSupplierById(@PathVariable String supCode) {
        return supplierService.getSelectedSupplier(supCode);
    }

    @PutMapping("/{supCode}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable String supCode, @RequestBody SupplierDTO supplierDTO) {
        SupplierDTO updatedSupplier = supplierService.updateSupplier(supCode, supplierDTO);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{supCode}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable String supCode) {
        boolean response = supplierService.deleteSupplier(supCode);
        if (response) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
