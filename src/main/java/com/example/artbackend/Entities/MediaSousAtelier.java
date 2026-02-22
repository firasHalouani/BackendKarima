package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class MediaSousAtelier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Path;
    @ManyToOne
    @JoinColumn(name = "sous_atelier_id")
    @JsonIgnore
    private SousAtelier sousAtelier;

    // Default constructor
    public MediaSousAtelier() {
    }

    // Custom constructor
    public MediaSousAtelier(String Path, SousAtelier sousAtelier) {
        this.Path = Path;
        this.sousAtelier = sousAtelier;
    }

    // All-args constructor
    public MediaSousAtelier(int id, String Path, SousAtelier sousAtelier) {
        this.id = id;
        this.Path = Path;
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

    public SousAtelier getSousAtelier() {
        return sousAtelier;
    }

    public void setSousAtelier(SousAtelier sousAtelier) {
        this.sousAtelier = sousAtelier;
    }
}
