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
public class CustomerDTO{
    private String code;
    private String name;
    private String gender;
    private LocalDate joinedDate;
    private String level;
    private double totPoints;
    private LocalDate dob;
    private String address;
    private String contact;
    private String email;
    private LocalDate recentPurchase;
    private List<SalesDTO> sales = new ArrayList<>();
}
