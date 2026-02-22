package com.example.artbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.artbackend.Entities.MediaEvent;

public interface MediaeventRepository extends JpaRepository<MediaEvent , Integer> {
    
}
