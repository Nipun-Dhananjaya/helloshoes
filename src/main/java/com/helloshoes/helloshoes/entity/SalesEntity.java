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
@Table(name = "sales")
@Entity
public class SalesEntity implements SuperEntity {
    @Id
    private String ordId;
    private LocalDate ordDate;
    private String payMethod;
    private double subtot;
    private double discount;
    private String ordStatus;
    @Column(name = "code")
    private String code;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    @JsonIgnore
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "code", referencedColumnName = "code", insertable = false, updatable = false)
    @JsonIgnore
    private CustomerEntity cust;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SalesItemEntity> items = new ArrayList<>();
}

