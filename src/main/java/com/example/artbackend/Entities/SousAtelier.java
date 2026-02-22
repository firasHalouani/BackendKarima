package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class SousAtelier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String Description;
    private String image;
    @ManyToOne
    private Atelier atelier;
    private Float prix;
    private boolean active;
    @OneToMany(mappedBy = "sousAtelier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaSousAtelier> media;

    // Default constructor
    public SousAtelier() {
    }

    // All-args constructor
    public SousAtelier(int id, String name, String Description, String image, Atelier atelier, Float prix,
            boolean active, List<MediaSousAtelier> media) {
        this.id = id;
        this.name = name;
        this.Description = Description;
        this.image = image;
        this.atelier = atelier;
        this.prix = prix;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<MediaSousAtelier> getMedia() {
        return media;
    }

    public void setMedia(List<MediaSousAtelier> media) {
        this.media = media;
    }
}
