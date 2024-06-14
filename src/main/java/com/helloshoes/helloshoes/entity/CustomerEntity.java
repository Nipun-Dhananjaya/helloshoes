package com.helloshoes.helloshoes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private LocalDate recentPurchase;
    @OneToMany(mappedBy = "cust")
    @JsonIgnore
    private List<SalesEntity> sales = new ArrayList<>();
}
