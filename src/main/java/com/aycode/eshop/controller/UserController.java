package com.aycode.eshop.controller;

import com.aycode.eshop.dto.UserDto;
import com.aycode.eshop.model.Utilisateur;
import com.aycode.eshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Utilisateur> addUser(@RequestBody Utilisateur utilisateur){
        return userService.addUser(utilisateur);
    }
    @GetMapping
    public ResponseEntity<List<Utilisateur>> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Utilisateur> findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<Utilisateur> updateUser(@PathVariable Long id, UserDto userDto){
        return userService.updateUser(id, userDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}
