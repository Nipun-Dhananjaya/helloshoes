package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dao.InventoryRepo;
import com.helloshoes.helloshoes.dao.SalesItemRepo;
import com.helloshoes.helloshoes.dao.SalesRepo;
import com.helloshoes.helloshoes.dto.SalesItemDTO;
import com.helloshoes.helloshoes.entity.InventoryEntity;
import com.helloshoes.helloshoes.entity.SalesEntity;
import com.helloshoes.helloshoes.entity.SalesItemEntity;
import com.helloshoes.helloshoes.service.SalesItemService;
import com.helloshoes.helloshoes.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SalesItemServiceIMPL implements SalesItemService {
    private final SalesItemRepo salesItemRepo;
    private final SalesRepo salesRepo;
    private final InventoryRepo inventoryRepo;
    private final Mapping mapping;

    @Override
    public SalesItemDTO saveSalesItem(SalesItemDTO salesItemDTO) {
        SalesItemEntity entity = mapping.toSalesItemEntity(salesItemDTO);
        return mapping.toSalesItemDTO(salesItemRepo.save(entity));
    }

    @Override
    public void deleteSalesItem(String salesItemId) {
        salesItemRepo.deleteById(String.valueOf(Long.parseLong(salesItemId)));
    }

    @Override
    public SalesItemDTO getSelectedSalesItem(String salesItemId) {
        return mapping.toSalesItemDTO(salesItemRepo.getReferenceById(String.valueOf(Long.parseLong(salesItemId))));
    }

    @Override
    public List<SalesItemDTO> getAllSalesItem() {
        return mapping.toSalesItemDTOList(salesItemRepo.findAll());
    }

    @Override
    public void updateSalesItem(String salesItemId, SalesItemDTO salesItemDTO) {
        SalesItemEntity entity = salesItemRepo.getReferenceById(Long.parseLong(salesItemId));
        entity.setQuantity(salesItemDTO.getQuantity());

        // Update the related sales entity if necessary
        if (salesItemDTO.getOrdId() != null) {
            SalesEntity salesEntity = salesRepo.findById(salesItemDTO.getOrdId()).orElseThrow(() -> new IllegalArgumentException("Invalid sales ID"));
            entity.setSales(salesEntity);
        }

        // Update the related inventory entity if necessary
        if (salesItemDTO.getItemId() != null) {
            InventoryEntity inventoryEntity = inventoryRepo.findById(salesItemDTO.getItemId()).orElseThrow(() -> new IllegalArgumentException("Invalid item ID"));
            entity.setInventory(inventoryEntity);
        }

        salesItemRepo.save(entity);
    }
}
