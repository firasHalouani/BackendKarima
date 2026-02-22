package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String Description;
    private String Formateur;
    private Date Debut;
    private Date Fin;
    private int heures;
    private Float prix;
    private String image;
    @Column(nullable = true)
    private boolean active;

    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaFormation> media;

    // Default constructor
    public Formation() {
    }

    // Custom constructor
    public Formation(int id) {
        this.id = id;
    }

    // All-args constructor
    public Formation(int id, String name, String Description, String Formateur, Date Debut, Date Fin, int heures,
            Float prix, String image, boolean active, List<MediaFormation> media) {
        this.id = id;
        this.name = name;
        this.Description = Description;
        this.Formateur = Formateur;
        this.Debut = Debut;
        this.Fin = Fin;
        this.heures = heures;
        this.prix = prix;
        this.image = image;
        this.active = active;
        this.media = media;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getFormateur() {
        return Formateur;
    }

    public void setFormateur(String Formateur) {
        this.Formateur = Formateur;
    }

    public Date getDebut() {
        return Debut;
    }

    public void setDebut(Date Debut) {
        this.Debut = Debut;
    }

    public Date getFin() {
        return Fin;
    }

    public void setFin(Date Fin) {
        this.Fin = Fin;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<MediaFormation> getMedia() {
        return media;
    }

    public void setMedia(List<MediaFormation> media) {
        this.media = media;
    }
}
