package com.helloshoes.helloshoes.service;

import com.helloshoes.helloshoes.dto.SupplierDTO;
import com.helloshoes.helloshoes.dto.UserDTO;

import java.util.List;

public interface UserService {
    SupplierDTO saveUser(UserDTO userDTO);
    void deleteUser(String email);
    SupplierDTO getSelectedUser(String email);
    List<SupplierDTO> getAllUsers();
    void updateUser(String email,UserDTO userDTO);
}
