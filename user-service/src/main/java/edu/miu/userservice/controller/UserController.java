package edu.miu.userservice.controller;

import edu.miu.userservice.dto.UserDTO;
import edu.miu.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Boolean registerNewUser(@RequestBody UserDTO dto) {
        return userService.createUser(dto);
    }

    @PutMapping("/{id}")
    public UserDTO updateExistingUser(@RequestBody UserDTO dto, @PathVariable Long id) {
        return userService.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
}
