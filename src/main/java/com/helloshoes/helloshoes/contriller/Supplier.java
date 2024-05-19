package com.helloshoes.helloshoes.contriller;

import com.helloshoes.helloshoes.dto.SupplierDTO;
import com.helloshoes.helloshoes.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class Supplier {
    private final SupplierService supplierService;
    @PostMapping
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplier) {
        return supplierService.saveSupplier(supplier);
    }
    @GetMapping
    public List<SupplierDTO> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{supplierId}")
    public SupplierDTO getSupplierById(@PathVariable String supplierId) {
        return supplierService.getSelectedSupplier(supplierId);
    }

    @PutMapping("/{supplierId}")
    public void updateSupplier(@PathVariable String supplierId, @RequestBody SupplierDTO supplierDTO) {
        supplierService.updateSupplier(supplierId, supplierDTO);
    }

    @DeleteMapping("/{supplierId}")
    public void deleteSupplier(@PathVariable String supplierId) {
        supplierService.deleteSupplier(supplierId);
    }
}
