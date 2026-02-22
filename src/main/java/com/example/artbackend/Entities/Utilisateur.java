package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String numero;
    private int age;
    private String image;
    private boolean statut;
    private String role;

    @OneToMany(mappedBy = "utilisateur")
    private List<adherent> adherents;

    // Default constructor
    public Utilisateur() {
    }

    // All-args constructor
    public Utilisateur(int id, String username, String nom, String prenom, String email, String password, String numero,
            int age, String image, boolean statut, String role, List<adherent> adherents) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.numero = numero;
        this.age = age;
        this.image = image;
        this.statut = statut;
        this.role = role;
        this.adherents = adherents;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<adherent> getAdherents() {
        return adherents;
    }

    public void setAdherents(List<adherent> adherents) {
        this.adherents = adherents;
    }
}
