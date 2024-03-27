package com.aycode.eshop.model;

import java.io.Serializable;
import java.util.Scanner;

public class Panier  implements Serializable  {

    private LigneCommande ligneCommande;

    public Panier(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }





}
