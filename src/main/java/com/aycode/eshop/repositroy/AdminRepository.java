package com.aycode.eshop.repositroy;

import com.aycode.eshop.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrateur, Long> {
}
