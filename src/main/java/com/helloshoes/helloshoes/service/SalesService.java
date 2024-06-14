package com.helloshoes.helloshoes.service;

import com.helloshoes.helloshoes.dto.SalesDTO;

import java.util.List;

public interface SalesService {
    SalesDTO saveSales(SalesDTO salesDTO);
    void deleteSales(String salesId);
    SalesDTO getSelectedSales(String salesId);
    List<SalesDTO> getAllSales();
    SalesDTO updateSales(String ordId, SalesDTO salesDTO);
}
