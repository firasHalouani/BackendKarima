package com.example.artbackend.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String Description;
    private Date dateDebut;
    private Date dateFin;
    private Float prix;
    private String image;
    @Column(nullable = true)
    private boolean active;
    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaEvent> media;

    // Default constructor
    public Evenement() {
    }

    // Custom constructor
    public Evenement(int id) {
        this.id = id;
    }

    // All-args constructor
    public Evenement(int id, String name, String Description, Date dateDebut, Date dateFin, Float prix, String image,
            boolean active, List<MediaEvent> media) {
        this.id = id;
        this.name = name;
        this.Description = Description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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

    public List<MediaEvent> getMedia() {
        return media;
    }

    public void setMedia(List<MediaEvent> media) {
        this.media = media;
    }
}
