package com.helloshoes.helloshoes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory")
@Entity
public class InventoryEntity implements SuperEntity{
    @Id
    private String itemId;
    private String itemName;
    private String picture;
    private String category;
    private double size;
    @ManyToOne
    @JoinColumn(name = "supCode")
    private SupplierEntity supplier;
    private double salePrice;
    private double buyPrice;
    private double expectedProfit;
    private double profitMargin;
    private double qtv;

    @ManyToMany(mappedBy = "item")
    private List<SalesEntity> sales = new ArrayList<>();
}
