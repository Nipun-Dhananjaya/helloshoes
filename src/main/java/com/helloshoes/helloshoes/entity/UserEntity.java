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
@Table(name = "user")
@Entity
public class UserEntity implements SuperEntity{
    @Id
    private String email;
    private String password;
    private String role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private EmployeeEntity emp;
    @OneToMany(mappedBy = "user")
    private List<SalesEntity> sales = new ArrayList<>();
}

