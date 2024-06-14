package com.helloshoes.helloshoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
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
    private String email;
    private String guardian;
    private String guardianCont;
    private UserDTO user;
}

