package com.helloshoes.helloshoes.service;

import com.helloshoes.helloshoes.dto.EmployeeDTO;
import com.helloshoes.helloshoes.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    InventoryDTO saveInventory(InventoryDTO inventoryDTO);
    void deleteInventory(String inventoryId);
    InventoryDTO getSelectedInventory(String inventoryId);
    List<InventoryDTO> getAllInventories();
    void updateInventory(String inventoryId,InventoryDTO inventoryDTO);
}
