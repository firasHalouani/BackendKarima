package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class MediaFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Path;

    @ManyToOne
    @JsonIgnore
    private Formation formation;

    // Default constructor
    public MediaFormation() {
    }

    // All-args constructor
    public MediaFormation(int id, String Path, Formation formation) {
        this.id = id;
        this.Path = Path;
        this.formation = formation;
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

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
