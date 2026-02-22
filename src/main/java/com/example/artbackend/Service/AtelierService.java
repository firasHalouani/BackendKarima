package com.example.artbackend.Service;

import com.example.artbackend.Entities.Atelier;
import com.example.artbackend.Entities.MediaSousAtelier;
import com.example.artbackend.Entities.SousAtelier;
import com.example.artbackend.Repository.AtelierRepository;
import com.example.artbackend.Repository.MediaeventRepository;
import com.example.artbackend.Repository.SousAtelierRepository;
import com.example.artbackend.Repository.mediaSousAtelierRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AtelierService {
    @Autowired
    AtelierRepository AR;

    @Autowired
    SousAtelierRepository SR;

    @Autowired
    private mediaSousAtelierRepository MAR;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;



public void AddAtelier(Atelier atelier){
    	AR.save(atelier);
	List<Atelier> Allatelier = this.GetAllAtelier();
	messagingTemplate.convertAndSend("/topic/atelier" , Allatelier );
}

public void update(Atelier atelier){
    	Optional<Atelier> atelier1 = AR.findById(atelier.getId());
            if (atelier1.isPresent()){
                atelier1.get().setName(atelier.getName());
                atelier1.get().setActive(atelier.isActive());
                atelier1.get().setImage(atelier.getImage());
                atelier1.get().setDescription(atelier.getDescription());
            }
    AR.save(atelier1.get());
	List<Atelier> Allatelier = this.GetAllAtelier();
	messagingTemplate.convertAndSend("/topic/atelier" , Allatelier );
}


public int  AddSousAtelier(SousAtelier atelier){



    SousAtelier sousAtelier = SR.save(atelier);
messagingTemplate.convertAndSend("/topic/sous-atelier" , atelier);

    return sousAtelier.getId();
}
public void DeleteSousAtelier(SousAtelier atelier){
    messagingTemplate.convertAndSend("/topic/Sousatelier" ,atelier);
    SR.deleteById(atelier.getId());
}

    public SousAtelier EditeSousAtelier(SousAtelier atelier){
        Optional<SousAtelier> sousAtelier1= SR.findById(atelier.getId());
        if (sousAtelier1.isPresent()){
            sousAtelier1.get().setName(atelier.getName());
            sousAtelier1.get().setActive(atelier.isActive());
            sousAtelier1.get().setPrix(atelier.getPrix());
            sousAtelier1.get().setImage(atelier.getImage());
            sousAtelier1.get().setDescription(atelier.getDescription());
            SousAtelier sousAtelier = SR.save(sousAtelier1.get());
            messagingTemplate.convertAndSend("/topic/sous-atelier" , atelier);
            return sousAtelier ;
        }else {
            return null;
        }
    }
public void DeleteAtelier(int id ){
    messagingTemplate.convertAndSend("/topic/atelier" ,"Hello,this is a test message!");
    AR.deleteById(id);

}


    public List<Atelier> GetAllAtelier(){
        return  AR.findAll();
    }


    public List<SousAtelier> GetAllSousAtelier(int id ){
        return  SR.findByAtelier_Id( id );}



        public void addMediaToAtelier(String Path , int id ) {
            Optional<SousAtelier> sousAtelier = SR.findById(id);
            if (sousAtelier.isPresent()) {
            MediaSousAtelier media = new MediaSousAtelier( Path , sousAtelier.get()) ;
            MAR.save(media);
            }

        }

        public void deleteMediaAtelie(int id ){
    MAR.deleteById(id);
        }



//    public void DeleteSousAtelierImage(String Path){
//        return SousAtelierRepository.
//    }
//
//    int changeStatusAtelier(int id){
//
//    }

}
