/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facades;

import dtos.SpeakerDTO;
import entities.Speaker;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author albie
 */
public class SpeakerFacade {
    private static SpeakerFacade instance;
    private static EntityManagerFactory emf;
    
    private SpeakerFacade(){}
    
    public static SpeakerFacade getSpeakerFacade(EntityManagerFactory _emf){
        if(instance == null){
            emf = _emf;
            instance = new SpeakerFacade();
        }
        return instance;
    }
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public SpeakerDTO create(SpeakerDTO spk){
        Speaker speak = new Speaker(spk.getName(), spk.getProfession(), spk.getGender());
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(speak);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return new SpeakerDTO(speak);
    }
    
    public List<SpeakerDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Speaker> query = em.createQuery("Select u From Speaker u", Speaker.class);
        List<Speaker> speaks = query.getResultList();
        return SpeakerDTO.getDTOs(speaks);
    }
    
    public SpeakerDTO getById(long id){
        EntityManager em = emf.createEntityManager();
        Speaker speak = em.find(Speaker.class, id);
        return new SpeakerDTO(speak);
    }
    
    public SpeakerDTO getByName(String name){
        EntityManager em = emf.createEntityManager();
        Speaker speak = em.find(Speaker.class, name);
        return new SpeakerDTO(speak);
    }
}
