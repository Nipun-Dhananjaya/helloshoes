package com.helloshoes.helloshoes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
@Entity
public class SalesEntity implements SuperEntity{
    @Id
    private String ordId;
    private LocalDate ordDate;
    private String payMethod;
    private double subtot;
    private double discount;
    @ManyToOne
    @JoinColumn(name = "email")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "code")
    private CustomerEntity customer;

    @ManyToMany
    @JoinTable(
            name = "sales_items",
            joinColumns = @JoinColumn(name = "itemId"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<InventoryEntity> item = new ArrayList<>();
}