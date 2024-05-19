package com.helloshoes.helloshoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesDTO {
    private String ordId;
    private LocalDate ordDate;
    private String payMethod;
    private double subtot;
    private double discount;
    private CustomerDTO customer;
    private List<InventoryDTO> item = new ArrayList<>();
    private UserDTO user;
}
