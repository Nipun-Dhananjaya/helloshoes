package com.helloshoes.helloshoes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Entity
public class EmployeeEntity implements SuperEntity{
    @Id
    private String empCode;
    private String empName;
    private String proPic;
    private String gender;
    private String status;
    private String designation;
    private String accessRole;
    private LocalDate dob;
    private LocalDate joinedDate;
    private String branch;
    private String address;
    private String contact;
    @Column(name = "email")
    private String email;
    private String guardian;
    private String guardianCont;
    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    @JsonIgnore
    private UserEntity user;
}

