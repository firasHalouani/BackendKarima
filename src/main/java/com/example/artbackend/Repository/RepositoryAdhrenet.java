package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Utilisateur;
import com.example.artbackend.Entities.adherent;

import org.apache.tomcat.util.openssl.openssl_h_Compatibility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

public interface RepositoryAdhrenet extends JpaRepository<adherent, Integer> {
    List<adherent> findAllByUtilisateur_Id(int id);



Optional<adherent> findByTypeAndIdTypeAndUtilisateur(String type, int idType, Utilisateur utilisateur);
}

