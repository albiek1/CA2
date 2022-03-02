/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import dtos.TalkDTO;
import entities.Conference;
import facades.ConferenceFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author albie
 */
@Path("conference")
public class ConferenceResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final ConferenceFacade conFac = ConferenceFacade.getConfFacade(EMF);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allConference(){
        return conFac.getAll().toString();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getId")
    public String getById(){
        return conFac.getByID(1).toString();
    }
    
    /*@POST
    @Path("create")
    public String create(){
        return "success";
    }*/
    
    public static void main(String[] args){
        System.out.println(conFac.getByID(1).toString());
        System.out.println(conFac.getAll().toString());
    }
}
