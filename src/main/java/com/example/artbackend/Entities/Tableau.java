package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Tableau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String Description;
    @Column(nullable = true)
    private float prix;
    private String image;
    @ManyToOne
    private Artiste artiste;

    // Default constructor
    public Tableau() {
    }

    // All-args constructor
    public Tableau(int id, String titre, String Description, float prix, String image, Artiste artiste) {
        this.id = id;
        this.titre = titre;
        this.Description = Description;
        this.prix = prix;
        this.image = image;
        this.artiste = artiste;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }
}
