package com.helloshoes.helloshoes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String socks;
    private String cleaner;
    @Column(name = "supCode")
    private String supCode;
    private double salePrice;
    private double buyPrice;
    private double expectedProfit;
    private double profitMargin;
    private double qtv;

    @ManyToMany(mappedBy = "item")
    private List<SalesEntity> sales = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "supCode", referencedColumnName = "supCode", insertable = false, updatable = false)
    @JsonIgnore
    private SupplierEntity supplier;
}
