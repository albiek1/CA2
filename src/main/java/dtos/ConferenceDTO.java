/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import entities.Conference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albie
 */
public class ConferenceDTO {
    private long id;
    private String name;
    private String location;
    private int capacity;
    private String date;
    private String time;
    
    public ConferenceDTO(String name, String location, int capacity, String date, String time){
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
    }
    
    public static List<ConferenceDTO> getDTOs(List<Conference> conf){
        List<ConferenceDTO> confdtos = new ArrayList<>();
        conf.forEach(con->confdtos.add(new ConferenceDTO(con)));
        return confdtos;
    }
    
    public ConferenceDTO(Conference con){
        if(con.getId() != null){
            this.id = con.getId();
        }
        this.name = con.getName();
        this.location = con.getLocation();
        this.capacity = con.getCapacity();
        this.date = con.getDate();
        this.time = con.getTime();
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getLocation(){
        return location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public String getTime(){
        return time;
    }
    
    public void setTime(String time){
        this.time = time;
    }
    
    @Override
    public String toString(){
        return "Conference{"+"id="+id+", name="+name+", location="+location+", capacity="+capacity+", date="+date+", time="+time+'}';
    }
}
