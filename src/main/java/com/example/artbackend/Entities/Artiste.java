package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artiste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String numero;
    private String image;
    @OneToMany(mappedBy = "artiste", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tableau> tableaux;

    // Default constructor
    public Artiste() {
    }

    // All-args constructor
    public Artiste(int id, String nom, String prenom, String email, String numero, String image,
            List<Tableau> tableaux) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numero = numero;
        this.image = image;
        this.tableaux = tableaux;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Tableau> getTableaux() {
        return tableaux;
    }

    public void setTableaux(List<Tableau> tableaux) {
        this.tableaux = tableaux;
    }
}