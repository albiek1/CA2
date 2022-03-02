/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import dtos.SpeakerDTO;
import dtos.TalkDTO;
import facades.SpeakerFacade;
import facades.TalkFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author albie
 */
public class SpeakerResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final SpeakerFacade spkFacade = SpeakerFacade.getSpeakerFacade(EMF);
    private static final TalkFacade tlkFacade = TalkFacade.getTalkFacade(EMF);
    
    public List<TalkDTO> getAllBySpeaker(long speakId){
        List<TalkDTO> results = new ArrayList<>();
        List<TalkDTO> talks = tlkFacade.getAll();
        for(TalkDTO tlk : talks){
            if(tlk.getId() == speakId){
                results.add(tlk);
            }
        }
        return results;
    }
}
