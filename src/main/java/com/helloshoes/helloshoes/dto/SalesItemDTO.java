package com.helloshoes.helloshoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesItemDTO {
    private Long id;
    private String ordId;
    private String itemId;
    private int quantity;
}

