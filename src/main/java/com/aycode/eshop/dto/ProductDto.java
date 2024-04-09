package com.aycode.eshop.dto;

import com.aycode.eshop.model.Categorie;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotEmpty(message = "designation is required")
    private String designation;
    @NotEmpty(message = "description is required")
    private String description;
    @NotNull(message = "qte is required")
    private int qte;
    @NotNull(message = "prix is required")
    private Double prix;
    @NotNull(message = "categories is required")
    private Long categorieId;

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }

    public int getQte() {
        return qte;
    }

    public Double getPrix() {
        return prix;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }
}
