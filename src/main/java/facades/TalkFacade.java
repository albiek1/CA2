/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facades;

import dtos.TalkDTO;
import entities.Talk;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author albie
 */
public class TalkFacade {
    private static TalkFacade instance;
    private static EntityManagerFactory emf;
    
    private TalkFacade(){}
    
    public static TalkFacade getTalkFacade(EntityManagerFactory _emf){
        if(instance == null){
            emf = _emf;
            instance = new TalkFacade();
        }
        return instance;
    }
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public TalkDTO create(TalkDTO tlk){
        Talk talk = new Talk(tlk.getTopic(), tlk.getDuration(), tlk.getPropslist());
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(talk);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return new TalkDTO(talk);
    }
    
    public List<TalkDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Talk> query = em.createQuery("Select u From Talk u", Talk.class);
        List<Talk> talks = query.getResultList();
        return TalkDTO.getDTOs(talks);
    }
    
    public TalkDTO getById(long id){
        EntityManager em = emf.createEntityManager();
        Talk talk = em.find(Talk.class, id);
        return new TalkDTO(talk);
    }
    
    public String removeTalk(long id){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("DELETE FROM Talk WHERE Id=id");
        query.executeUpdate();
        return "Success";
    }
    
    /*public List<TalkDTO> getAllBySpeaker(long id){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Talk> query = em.createQuery("Select idtalk From speaker_talk Where idspeaker=id", Talk.class);
        List
    }*/
}
