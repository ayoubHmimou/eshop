package com.aycode.eshop.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;
@Entity
@DiscriminatorValue(value = "ADMIN")
public class Administrateur extends Utilisateur implements Serializable {

}
