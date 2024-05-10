package com.helloshoes.helloshoes.contriller;

import com.helloshoes.helloshoes.dto.SalesDTO;
import com.helloshoes.helloshoes.dto.UserDTO;
import com.helloshoes.helloshoes.service.SalesService;
import com.helloshoes.helloshoes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class Sales {
    private final SalesService salesService;
    @PostMapping
    public SalesDTO saveSales(@RequestBody SalesDTO user) {
        return salesService.saveSales(user);
    }
    @GetMapping
    public List<SalesDTO> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{salesId}")
    public SalesDTO getSalesById(@PathVariable String salesId) {
        return salesService.getSelectedSales(salesId);
    }

    @PutMapping("/{salesId}")
    public void updateSales(@PathVariable String salesId, @RequestBody SalesDTO userDTO) {
        salesService.updateSales(salesId, userDTO);
    }

    @DeleteMapping("/{salesId}")
    public void deleteSales(@PathVariable String salesId) {
        salesService.deleteSales(salesId);
    }
}
