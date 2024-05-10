package com.helloshoes.helloshoes.contriller;

import com.helloshoes.helloshoes.dto.InventoryDTO;
import com.helloshoes.helloshoes.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class Inventory {
    private final InventoryService inventoryService;
    @PostMapping
    public InventoryDTO saveInventory(@RequestBody InventoryDTO inventory) {
        return inventoryService.saveInventory(inventory);
    }
    @GetMapping
    public List <InventoryDTO> getAllInventorys() {
        return inventoryService.getAllInventories();
    }

    @GetMapping("/{inventoryId}")
    public InventoryDTO getInventoryById(@PathVariable String inventoryId) {
        return inventoryService.getSelectedInventory(inventoryId);
    }

    @PutMapping("/{inventoryId}")
    public void updateInventory(@PathVariable String inventoryId, @RequestBody InventoryDTO inventoryDTO) {
        inventoryService.updateInventory(inventoryId, inventoryDTO);
    }

    @DeleteMapping("/{inventoryId}")
    public void deleteInventory(@PathVariable String inventoryId) {
        inventoryService.deleteInventory(inventoryId);
    }
}
