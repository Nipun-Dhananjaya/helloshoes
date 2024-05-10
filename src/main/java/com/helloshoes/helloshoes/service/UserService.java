package com.helloshoes.helloshoes.service;

import com.helloshoes.helloshoes.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    void deleteUser(String email);
    UserDTO getSelectedUser(String email);
    List<UserDTO> getAllUsers();
    void updateUser(String email,UserDTO userDTO);
}
