package com.helloshoes.helloshoes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales_items")
@Entity
public class SalesItemEntity implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ordId")
    @JsonIgnore
    private SalesEntity sales;

    @ManyToOne
    @JoinColumn(name = "itemId")
    @JsonIgnore
    private InventoryEntity inventory;

    private int quantity;
}

