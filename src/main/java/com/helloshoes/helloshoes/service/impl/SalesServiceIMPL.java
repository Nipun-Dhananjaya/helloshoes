package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dao.InventoryRepo;
import com.helloshoes.helloshoes.dao.SalesItemRepo;
import com.helloshoes.helloshoes.dao.SalesRepo;
import com.helloshoes.helloshoes.dto.*;
import com.helloshoes.helloshoes.entity.InventoryEntity;
import com.helloshoes.helloshoes.entity.SalesEntity;
import com.helloshoes.helloshoes.entity.SalesItemEntity;
import com.helloshoes.helloshoes.service.CustomerService;
import com.helloshoes.helloshoes.service.SalesService;
import com.helloshoes.helloshoes.service.UserService;
import com.helloshoes.helloshoes.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SalesServiceIMPL implements SalesService {
    private final SalesRepo salesRepo;
    private final InventoryRepo inventoryRepo;
    private final SalesItemRepo salesItemRepo;
    private final Mapping mapping;

    @Override
    public SalesDTO saveSales(SalesDTO salesDTO) {
        SalesEntity sales = mapping.toSales(salesDTO);

        for (SalesItemDTO itemDTO : salesDTO.getItems()) {
            SalesItemEntity item = new SalesItemEntity();
            item.setSales(sales);
            InventoryEntity referenceById = inventoryRepo.getReferenceById(itemDTO.getItemId());
            if (referenceById == null) {
                throw new IllegalArgumentException("Inventory not found for Item ID: " + itemDTO.getItemId());
            }
            item.setInventory(referenceById);
            item.setQuantity(itemDTO.getQuantity());
            System.out.println(sales);
            System.out.println(referenceById.getItemId());
            sales.getItems().add(item);
            System.out.println(item.getInventory()==null);
        }
        if (salesDTO.getCode() == null || salesDTO.getCode().isEmpty() ) {
            throw new IllegalArgumentException("Customer Code must be provided");
        }
        if (salesDTO.getEmail() == null || salesDTO.getEmail().isEmpty() ) {
            throw new IllegalArgumentException("User Email must be provided");
        }
        return mapping.toSalesDTO(salesRepo.save(sales));
    }

    @Override
    public void deleteSales(String salesId) {
        salesRepo.deleteById(salesId);
    }

    @Override
    public SalesDTO getSelectedSales(String salesId) {
        return mapping.toSalesDTO(salesRepo.getReferenceById(salesId));
    }

    @Override
    public List<SalesDTO> getAllSales() {
        List<SalesEntity> salesEntities = salesRepo.findAll();
        List<SalesDTO> salesDTOS = mapping.toSalesDTOList(salesEntities);

        List<SalesItemDTO> salesItemDTOS = mapping.toSalesItemDTOList(salesItemRepo.findAll());

        for (SalesDTO salesDTO : salesDTOS) {
            List<SalesItemDTO> salesItemList = new ArrayList<>();
            for (SalesItemDTO salesItemDTO : salesItemDTOS) {
                if (salesItemDTO.getOrdId()!=null) {
                    if (salesItemDTO.getOrdId().equals(salesDTO.getOrdId())) {
                        salesItemList.add(salesItemDTO);
                    }
                }
            }
            salesDTO.setItems(salesItemList);
        }
        return salesDTOS;
    }


    @Override
    @Transactional
    public SalesDTO updateSales(String ordId, SalesDTO salesDTO) {
        SalesDTO salesDTO1 = mapping.toSalesDTO(salesRepo.getReferenceById(ordId));
        salesDTO1.setOrdStatus(salesDTO.getOrdStatus());
        salesRepo.save(mapping.toSales(salesDTO1));
        return salesDTO1;
    }
}

