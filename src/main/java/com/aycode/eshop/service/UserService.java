package com.aycode.eshop.service;

import com.aycode.eshop.dto.UserDto;
import com.aycode.eshop.model.Utilisateur;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<Utilisateur> addUser(Utilisateur user);
    ResponseEntity<List<Utilisateur>>getUsers();
    ResponseEntity<Utilisateur> updateUser(Long id, UserDto userDto);
    ResponseEntity<Utilisateur> findUserById(Long id);
    ResponseEntity<String> deleteUser(Long id);
}
