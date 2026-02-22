package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Path;
    @ManyToOne
    @JsonIgnore
    private Evenement evenement;
    @ManyToOne
    @JsonIgnore
    private Formation formation;
    @ManyToOne
    @JsonIgnore
    private SousAtelier sousAtelier;

    // Default constructor
    public Media() {
    }

    // All-args constructor
    public Media(int id, String Path, Evenement evenement, Formation formation, SousAtelier sousAtelier) {
        this.id = id;
        this.Path = Path;
        this.evenement = evenement;
        this.formation = formation;
        this.sousAtelier = sousAtelier;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public SousAtelier getSousAtelier() {
        return sousAtelier;
    }

    public void setSousAtelier(SousAtelier sousAtelier) {
        this.sousAtelier = sousAtelier;
    }
}
