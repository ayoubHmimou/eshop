package com.aycode.eshop.model;

import jakarta.persistence.*;
import jdk.jfr.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String designation;
    private String description;
    private int qte;
    private Double prix;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> ligneCommandes = new ArrayList<>();

    public Produit(String designation, String description, int qte, Double prix) {
        this.designation = designation;
        this.description = description;
        this.qte = qte;
        this.prix = prix;
    }

    public Produit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }
}
