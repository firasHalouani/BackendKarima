package com.example.artbackend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.artbackend.Entities.Formation;
import com.example.artbackend.Entities.MediaFormation;

public interface MediaFormationRepository  extends JpaRepository<MediaFormation, Integer> {
    
}
