package com.aycode.eshop.controller;

import com.aycode.eshop.model.Administrateur;
import com.aycode.eshop.repositroy.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminRepository adminRepository;
    public AdminController(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @PostMapping
    public ResponseEntity<Administrateur> addAdmin(@RequestBody Administrateur administrateur){
        Administrateur administrateurSaved =  adminRepository.save(administrateur);

        return ResponseEntity.ok().body(administrateurSaved);

    }
}
