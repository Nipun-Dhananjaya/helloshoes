package com.helloshoes.helloshoes.controller;

import com.helloshoes.helloshoes.dto.SalesDTO;
import com.helloshoes.helloshoes.dto.SalesItemDTO;
import com.helloshoes.helloshoes.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class SalesController {
    private final SalesService salesService;
    @PostMapping
    public SalesDTO saveSales(@RequestBody SalesDTO sales) {
        for (SalesItemDTO salesItemDTO: sales.getItems()) {
            salesItemDTO.setOrdId(sales.getOrdId());
        }
        return salesService.saveSales(sales);
    }

    @GetMapping
    public List<SalesDTO> getAllSales() {
        return salesService.getAllSales();

    }

    @GetMapping("/{ordId}")
    public SalesDTO getSalesById(@PathVariable String ordId) {
        return salesService.getSelectedSales(ordId);
    }

    @PutMapping("/{ordId}")
    public ResponseEntity<SalesDTO> updateSales(@PathVariable String ordId, @RequestBody SalesDTO salesDTO) {
        SalesDTO salesDTO1 = salesService.updateSales(ordId, salesDTO);
        return ResponseEntity.ok(salesDTO1);
    }

    @DeleteMapping("/{ordId}")
    public void deleteSales(@PathVariable String ordId) {
        salesService.deleteSales(ordId);
    }
}
