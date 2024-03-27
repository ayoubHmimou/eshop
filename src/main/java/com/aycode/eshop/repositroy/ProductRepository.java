package com.aycode.eshop.repositroy;

import com.aycode.eshop.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Produit, Long> {
    @Query("SELECT p FROM Produit p WHERE p.designation = ?1")
    Produit findProduitByDesignation(String designation);
    List<Produit> findAllByOrderByPrixAsc();
}
