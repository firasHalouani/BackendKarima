package com.example.artbackend.Service;

import com.example.artbackend.Entities.Formation;
import com.example.artbackend.Entities.MediaFormation;
import com.example.artbackend.Repository.FormationRepository;
import com.example.artbackend.Repository.MediaFormationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {

    @Autowired
    private FormationRepository FR;

    @Autowired
    private MediaFormationRepository MFR;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


     public List<Formation> GetAllFormation(){
         return  FR.findAll();}



public void  AddFormation(Formation formation ){
        FR.save(formation);
	List<Formation>  formations =  this.GetAllFormation();
	messagingTemplate.convertAndSend("/topic/formation" ,  formations );
     }

     public void EditFormation(Formation formation){
         Optional<Formation> f =  FR.findById(formation.getId());
         if ( f.isPresent() ){
         formation.setMedia(f.get().getMedia());
         FR.save(formation);
         } else {
             throw  new RuntimeException("Formation Not Found");
         }
     }



public void DeleteFormation(int id ){
         messagingTemplate.convertAndSend("/topic/formation" ,"Hello,this is a test message!");
         FR.deleteById(id);
}




public void addMediaFormation(String path ,  int  id) {
    MediaFormation fr = new MediaFormation();
    fr.setPath(path);
    fr.setFormation(new Formation(id));
    MFR.save(fr);

}

public void deleteMediaFormation(int id ){
         MFR.deleteById(id);
}


}
