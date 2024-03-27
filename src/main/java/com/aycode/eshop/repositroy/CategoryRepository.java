package com.aycode.eshop.repositroy;

import com.aycode.eshop.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categorie, Long> {

    public Categorie findCategorieById(Long id);
}
