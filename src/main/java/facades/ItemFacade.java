/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facades;

import dtos.ItemDTO;
import entities.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * @author albie
 */
public class ItemFacade {
    private static ItemFacade instance;
    private static EntityManagerFactory emf;
    
    private ItemFacade(){};
    
    public static ItemFacade getItemFacade(EntityManagerFactory _emf){
        if(instance == null){
            emf = _emf;
            instance = new ItemFacade();
        }
        return instance;
    }
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public ItemDTO create(ItemDTO itm){
        Item itme = new Item(itm.getStr1(), itm.getStr2());
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(itme);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return new ItemDTO(itme);
    }
    
    public long getItemCount(){
        EntityManager em = getEntityManager();
        try{
            long itemCount = (long)em.createQuery("SELECT COUNT(i) FROM Item i").getSingleResult();
            return itemCount;
        }finally{
            em.close();
        }
    }
    
    public ItemDTO getById(long id){
        EntityManager em = emf.createEntityManager();
        Item itm = em.find(Item.class, id);
        return new ItemDTO(itm);
    }
    
    public List<ItemDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Item> query = em.createQuery("SELECT r FROM Item r", Item.class);
        List<Item> itms = query.getResultList();
        return ItemDTO.getDTOs(itms);
    }
    
    public void updateItem(String str1, long id){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Item> query = em.createQuery("UPDATE Item SET Str1=str1 WHERE ID=id", Item.class);
    }
    
    public static void main(String[] args){
        emf = EMF_Creator.createEntityManagerFactory();
        ItemFacade fi = getItemFacade(emf);
        System.out.println("Count: "+fi.getItemCount());
        fi.getAll().forEach(dto->System.out.println(dto));
        fi.create(new ItemDTO(new Item("test str "+fi.getItemCount()*2+1L, "test str "+fi.getItemCount()*2+2L)));
    }
}
