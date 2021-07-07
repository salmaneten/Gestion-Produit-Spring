package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
//ANOTATION JPA PUISQUE ON A UNE BASE DE DONNEES RELATIONNEL
@Entity
public class Produit implements Serializable {
    @Id @GeneratedValue
    private  Long id;

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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    private String designation;
    private  int quantite;
    private double prix;
    public Produit(){
        super();
    }
    public Produit(String designation, int quantite, double prix){
        super();
        this.designation= designation;
        this.quantite = quantite;
        this.prix = prix;
    }

}
