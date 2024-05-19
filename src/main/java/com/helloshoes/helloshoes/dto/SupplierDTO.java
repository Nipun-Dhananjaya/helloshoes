package com.helloshoes.helloshoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {
    private String supCode;
    private String supName;
    private String category;
    private String address;
    private String contactOne;
    private String contactTwo;
    private String email;
    private List<InventoryDTO> items = new ArrayList<>();
}
