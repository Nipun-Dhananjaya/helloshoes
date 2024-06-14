package com.helloshoes.helloshoes.service;

import com.helloshoes.helloshoes.dto.SalesItemDTO;

import java.util.List;

public interface SalesItemService {
    SalesItemDTO saveSalesItem(SalesItemDTO salesItemDTO);
    void deleteSalesItem(String salesId);
    SalesItemDTO getSelectedSalesItem(String salesItemId);
    List<SalesItemDTO> getAllSalesItem();
    void updateSalesItem(String salesItemId,SalesItemDTO salesItemDTO);
}
