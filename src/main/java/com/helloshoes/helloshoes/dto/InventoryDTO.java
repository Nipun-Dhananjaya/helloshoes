package com.helloshoes.helloshoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {
    private String itemId;
    private String itemName;
    private String picture;
    private String category;
    private double size;
    private SupplierDTO supplier;
    private double salePrice;
    private double buyPrice;
    private double expectedProfit;
    private double profitMargin;
    private double qtv;
    private List<SalesDTO> sales = new ArrayList<>();
}
