package com.helloshoes.helloshoes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
@Entity
public class SupplierEntity implements SuperEntity{
    @Id
    private String supCode;
    private String supName;
    private String category;
    private String address;
    private String contactOne;
    private String contactTwo;
    private String email;
    @OneToMany(mappedBy = "supplier")
    private List<InventoryEntity> items = new ArrayList<>();
}
