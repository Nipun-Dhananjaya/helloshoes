package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dto.InventoryDTO;
import com.helloshoes.helloshoes.service.InventoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {
    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        return null;
    }

    @Override
    public void deleteInventory(String inventoryId) {

    }

    @Override
    public InventoryDTO getSelectedInventory(String inventoryId) {
        return null;
    }

    @Override
    public List<InventoryDTO> getAllInventories() {
        return null;
    }

    @Override
    public void updateInventory(String inventoryId, InventoryDTO inventoryDTO) {

    }
}
