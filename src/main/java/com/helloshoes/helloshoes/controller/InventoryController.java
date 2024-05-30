package com.helloshoes.helloshoes.controller;

import com.helloshoes.helloshoes.dto.InventoryDTO;
import com.helloshoes.helloshoes.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class InventoryController {
    private final InventoryService inventoryService;
    @PostMapping
    public InventoryDTO saveInventory(@RequestBody InventoryDTO inventory) {
        return inventoryService.saveInventory(inventory);
    }
    @GetMapping
    public List <InventoryDTO> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @GetMapping("/{itemId}")
    public InventoryDTO getInventoryById(@PathVariable String itemId) {
        return inventoryService.getSelectedInventory(itemId);
    }

    @PutMapping("/{itemId}")
    public void updateInventory(@PathVariable String itemId, @RequestBody InventoryDTO inventoryDTO) {
        inventoryService.updateInventory(itemId, inventoryDTO);
    }

    @DeleteMapping("/{itemId}")
    public void deleteInventory(@PathVariable String itemId) {
        inventoryService.deleteInventory(itemId);
    }
}
