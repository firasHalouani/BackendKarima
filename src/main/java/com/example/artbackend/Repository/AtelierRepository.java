package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Atelier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AtelierRepository extends JpaRepository<Atelier , Integer> {

    @Modifying
    @Query("UPDATE Atelier a SET a.active = CASE WHEN a.active = true THEN false ELSE true END WHERE a.id = :id")
    int toggleActive(@Param("id") int id);




}
