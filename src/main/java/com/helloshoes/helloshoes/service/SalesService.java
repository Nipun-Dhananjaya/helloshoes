package com.helloshoes.helloshoes.service;

import com.helloshoes.helloshoes.dto.EmployeeDTO;
import com.helloshoes.helloshoes.dto.SalesDTO;

import java.util.List;

public interface SalesService {
    SalesDTO saveSales(SalesDTO salesDTO);
    void deleteSales(String salesId);
    SalesDTO getSelectedSales(String salesId);
    List<SalesDTO> getAllSales();
    void updateSales(String salesId,SalesDTO salesDTO);
}
