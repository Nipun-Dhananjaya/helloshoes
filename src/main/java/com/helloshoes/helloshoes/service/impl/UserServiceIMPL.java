package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dao.UserRepo;
import com.helloshoes.helloshoes.dto.UserDTO;
import com.helloshoes.helloshoes.service.UserService;
import com.helloshoes.helloshoes.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserRepo repo;
    private final Mapping mapping;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return mapping.toUserDTO(repo.save(mapping.toUser(userDTO)));
    }

    @Override
    public void deleteUser(String email) {
        UserDTO userDTO = mapping.toUserDTO(repo.getReferenceById(email));
        repo.delete(mapping.toUser(userDTO));
    }

    @Override
    public UserDTO getSelectedUser(String email) {
        return mapping.toUserDTO(repo.getReferenceById(email));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapping.toUserDTOList(repo.findAll());
    }

    @Override
    public void updateUser(String email, UserDTO userDTO) {
        UserDTO userDTO1 = mapping.toUserDTO(repo.getReferenceById(email));
        userDTO1.setEmail(userDTO.getEmail());
        userDTO1.setPassword(userDTO.getPassword());
        userDTO1.setRole(userDTO.getRole());
        userDTO1.setEmp(userDTO.getEmp());
        userDTO1.setSales(userDTO.getSales());
        repo.save(mapping.toUser(userDTO1));
    }
}

