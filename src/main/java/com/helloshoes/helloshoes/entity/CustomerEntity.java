package com.helloshoes.helloshoes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Entity
public class CustomerEntity implements SuperEntity{
    @Id
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
    @OneToMany(mappedBy = "customer")
    private List<SalesEntity> sales = new ArrayList<>();
}
