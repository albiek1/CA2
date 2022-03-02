/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facades;

import dtos.ConferenceDTO;
import entities.Conference;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * @author albie
 */
public class ConferenceFacade {
    private static ConferenceFacade instance;
    private static EntityManagerFactory emf;
    
    private ConferenceFacade(){}
    
    public static ConferenceFacade getConfFacade(EntityManagerFactory _emf){
        if(instance == null){
            emf = _emf;
            instance = new ConferenceFacade();
        }
        return instance;
    }
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public ConferenceDTO create(ConferenceDTO con){
        Conference conf = new Conference(con.getName(), con.getLocation(), con.getCapacity(), con.getDate(), con.getTime());
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(conf);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return new ConferenceDTO(conf);
    }
    
    public ConferenceDTO getByID(long id){
        EntityManager em = emf.createEntityManager();
        Conference conf = em.find(Conference.class, id);
        return new ConferenceDTO(conf);
    }
    
    public List<ConferenceDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Conference> query = em.createQuery("Select c From Conference c", Conference.class);
        List<Conference> confs = query.getResultList();
        return ConferenceDTO.getDTOs(confs);
    }
    
    public static void main(String[] args){
        emf = EMF_Creator.createEntityManagerFactory();
        ConferenceFacade cf = getConfFacade(emf);
        System.out.println(cf.getByID(1).toString());
        cf.getAll().forEach(dto->System.out.println(dto));
    }
}
