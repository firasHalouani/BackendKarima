package com.example.artbackend.Controller;

import com.example.artbackend.Entities.*;
import com.example.artbackend.Service.AtelierService;
import com.example.artbackend.Service.EvenementService;
import com.example.artbackend.Service.FormationService;
import com.example.artbackend.Service.MediaService;
import com.example.artbackend.Service.TableauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("Admin")
@CrossOrigin(origins = "*"  )

public class Admin {

    @Autowired
    TableauService  TS;




    
    @Autowired
    AtelierService AS;

    @Autowired
    MediaService MS;



    @Autowired
    EvenementService ES;


    
    @Autowired
    private FormationService formationService;


    @PostMapping("/createArtiste")
    public ResponseEntity<HttpStatus> createArtiste(@RequestBody Artiste a) {
        try {
            TS.createArtiste(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/createTableau")
    public ResponseEntity<HttpStatus> createTableau(@RequestBody Tableau t) {
        try {
            TS.createTableau(t);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/DeletArtiste/{id}")
    public  ResponseEntity<HttpStatus> deleteArtiste(@PathVariable int  id) {
        try {
            TS.deleteArtiste(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/DeletTableau")
    public  ResponseEntity<HttpStatus> deleteTableau(@RequestParam int id ) {
        try {
            TS.deleteTableau(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
      //Atlier
    @PostMapping("/addAtelier")
    public ResponseEntity<HttpStatus> addAtelier(@RequestBody Atelier a) {
        try{
            a.setActive(true);
            AS.AddAtelier(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/EditAtelier")
    public ResponseEntity<HttpStatus> update(@RequestBody Atelier a) {
        try{
            AS.update(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/DeleteAtelier/{id}")
    public ResponseEntity<HttpStatus> DeleteAtelier(@PathVariable int id ) {
        try{
            AS.DeleteAtelier(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//Sous atelier
    @PostMapping("/addSousAtelier")
    public ResponseEntity<Integer> SousAtelier(@RequestBody SousAtelier a) {
        try{
            a.setActive(true);
            int id = AS.AddSousAtelier(a);
            return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/DeleteSousAtelier")
    public ResponseEntity<HttpStatus> DeleteSousAtelier(@RequestBody SousAtelier a) {
        try{
            AS.DeleteSousAtelier(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/EditSousAtelier")
    public ResponseEntity<Map<String , Object>> EditSousAtelier(@RequestBody SousAtelier a) {
        HashMap<String , Object> response= new  HashMap<>();
        try{
            SousAtelier sousAtelier = AS.EditeSousAtelier(a);
            response.put("status " , "succes") ;
            response.put("sous atelier " , sousAtelier);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        }catch (Exception e){
            response.put("status " , "fail") ;
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/AddMedia")
    public ResponseEntity<HttpStatus> addMedia(@RequestParam String path, @RequestParam String type , @RequestParam int id  ) {
        try {
            if (path == null || path.isEmpty() || type == null || type.isEmpty() || id <= 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            MS.AddMedia(path , type , id );
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping("/DeletMedia/{id}")
    public ResponseEntity<HttpStatus> DeleteMedia(@PathVariable int id ){
        try{
            MS.DeleteMedia(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/AddEvenement")
    public ResponseEntity<HttpStatus>  addEvenement(@RequestBody Evenement evenement){
        try {
            evenement.setActive(true);
            ES.AddEvenement(evenement);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/EditEvenement")
    public ResponseEntity<Map<String, Object>> editEvenement(@RequestBody Evenement e) {
        HashMap<String, Object> response = new HashMap<>();
        try {
            Evenement updatedEvent = ES.EditeEvenement(e);
            response.put("status", "success");
            response.put("evenement", updatedEvent);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            response.put("status", "fail");
            response.put("error", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/AddMediaFormation")
    public ResponseEntity<Void> addMediaFormation(@RequestParam String path , @RequestParam int id) {
            try {
                formationService.addMediaFormation(path , id);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    @PostMapping("/AddMediaToEvent")
    public ResponseEntity<Void> addMediaToEvent(@RequestParam String path , @RequestParam int id) {
        try {
            ES.addMediaToEvent(path , id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/AddMediaToAtelier")
    public ResponseEntity<Void> addMediaToAtelier(@RequestParam String Path , int id ) {
        try {

            AS.addMediaToAtelier(Path , id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//DeleteMedia :

// DELETE MEDIA ENDPOINTS

    @DeleteMapping("/DeleteMediaFormation")
    public ResponseEntity<Void> deleteMediaFormation(@RequestParam int mediaId) {
        try {
            formationService.deleteMediaFormation(mediaId);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/DeleteMediaEvent")
    public ResponseEntity<Void> deleteMediaEvent(@RequestParam int mediaId) {
        try {
            ES.DeleteMediaEvent(mediaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/DeleteMediaAtelier")
    public ResponseEntity<Void> deleteMediaAtelier(@RequestParam int mediaId) {
        try {
            AS.deleteMediaAtelie(mediaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }










}
