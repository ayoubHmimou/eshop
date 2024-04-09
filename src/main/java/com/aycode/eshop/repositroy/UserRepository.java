package com.aycode.eshop.repositroy;

import com.aycode.eshop.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email);
}
