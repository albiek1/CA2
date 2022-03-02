/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import entities.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author albie
 */
@Path("item")
public class ItemResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public String addItem(){
        EntityManager em = EMF.createEntityManager();
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allItems(){
        EntityManager em = EMF.createEntityManager();
        try{
            TypedQuery<Item> query = em.createQuery("select u from Item u", entities.Item.class);
            List<Item> items = query.getResultList();
            return "[" + items.size() + "]";
        }finally{
            em.close();
        }
    }
}
