package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dao.InventoryRepo;
import com.helloshoes.helloshoes.dto.InventoryDTO;
import com.helloshoes.helloshoes.service.InventoryService;
import com.helloshoes.helloshoes.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {
    private final InventoryRepo repo;
    private final Mapping mapping;
    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        return mapping.toInventoryDTO(repo.save(mapping.toInventory(inventoryDTO)));
    }

    @Override
    public void deleteInventory(String inventoryId) {
        InventoryDTO inventoryDTO = mapping.toInventoryDTO(repo.getReferenceById(inventoryId));
        repo.delete(mapping.toInventory(inventoryDTO));
    }

    @Override
    public InventoryDTO getSelectedInventory(String inventoryId) {
        return mapping.toInventoryDTO(repo.getReferenceById(inventoryId));
    }

    @Override
    public List<InventoryDTO> getAllInventories() {
        return mapping.toInventoryDTOList(repo.findAll());
    }

    @Override
    public void updateInventory(String inventoryId, InventoryDTO inventoryDTO) {
        InventoryDTO inventDTO = mapping.toInventoryDTO(repo.getReferenceById(inventoryId));
        inventDTO.setItemName(inventoryDTO.getItemName());
        inventDTO.setPicture(inventoryDTO.getPicture());
        inventDTO.setCategory(inventoryDTO.getCategory());
        inventDTO.setSize(inventoryDTO.getSize());
        inventDTO.setSalePrice(inventoryDTO.getSalePrice());
        inventDTO.setBuyPrice(inventoryDTO.getBuyPrice());
        inventDTO.setExpectedProfit(inventoryDTO.getExpectedProfit());
        inventDTO.setProfitMargin(inventoryDTO.getProfitMargin());
        inventDTO.setQtv(inventoryDTO.getQtv());
        inventDTO.setSupplier(inventoryDTO.getSupplier());
        inventDTO.setSales(inventoryDTO.getSales());
        repo.save(mapping.toInventory(inventDTO));
    }
}
