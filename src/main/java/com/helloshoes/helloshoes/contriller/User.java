package com.helloshoes.helloshoes.contriller;

import com.helloshoes.helloshoes.dto.UserDTO;
import com.helloshoes.helloshoes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class User {
    private final UserService userService;
    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO user) {
        return userService.saveUser(user);
    }
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public UserDTO getUserById(@PathVariable String email) {
        return userService.getSelectedUser(email);
    }

    @PutMapping("/{email}")
    public void updateUser(@PathVariable String email, @RequestBody UserDTO userDTO) {
        userService.updateUser(email, userDTO);
    }

    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }
}

