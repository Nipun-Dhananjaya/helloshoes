package com.helloshoes.helloshoes.entity;

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
@Table(name = "user")
@Entity
public class UserEntity implements SuperEntity{
    @Id
    private String email;
    private String password;
    private String role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private EmployeeEntity emp;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<SalesEntity> sales = new ArrayList<>();
}

