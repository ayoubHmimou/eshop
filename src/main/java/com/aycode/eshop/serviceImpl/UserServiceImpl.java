package com.aycode.eshop.serviceImpl;

import com.aycode.eshop.dto.UserDto;
import com.aycode.eshop.model.Utilisateur;
import com.aycode.eshop.repositroy.UserRepository;
import com.aycode.eshop.response.ResourceNotFoundException;
import com.aycode.eshop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Utilisateur> addUser(Utilisateur user) {
        Utilisateur utilisateur = userRepository.save(user);

        return ResponseEntity.ok().body(utilisateur);
    }
    @Override
    public ResponseEntity<List<Utilisateur>> getUsers(){
        List<Utilisateur> users = userRepository.findAll();

        return ResponseEntity.ok().body(users);
    }

    @Override
    public ResponseEntity<Utilisateur> updateUser(Long id, UserDto userDto) {
        Utilisateur existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist"));

        boolean updated = false;

        if(userDto.getPrenom() != null){
            existingUser.setNom(userDto.getNom());
            updated = true;
        }
        if(userDto.getPrenom() != null){
            existingUser.setPrenom(userDto.getPrenom());
        }

        if(!updated){
            return ResponseEntity.ok().body(existingUser);
        }

        Utilisateur updatedUser = userRepository.save(existingUser);

        return ResponseEntity.ok().body(updatedUser);
    }

    @Override
    public ResponseEntity<Utilisateur> findUserById(Long id) {
        Utilisateur utilisateur = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist"));

        return ResponseEntity.ok().body(utilisateur);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        Utilisateur utilisateur = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist"));
        userRepository.delete(utilisateur);

        return ResponseEntity.ok().body("user deleted successfully");
    }
}
