package com.aycode.eshop.dto;

import com.aycode.eshop.model.Categorie;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
}
