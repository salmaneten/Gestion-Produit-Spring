package org.sid.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
//ANOTATION JPA PUISQUE ON A UNE BASE DE DONNEES RELATIONNEL
@Entity
public class Produit implements Serializable {
    @Id @GeneratedValue
    private  Long id;
    @NotBlank(message = "designation doit pas être vide")
    @Size(min=4, max=15)
    private String designation;

    private  int quantite;
    @DecimalMin(value = "100", message = "le prix doit être supérieur à 100")
    private double prix;

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
