/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author albie
 */
@Entity
public class Conference implements Serializable{

    @Id
    private Long id;
    
    public Conference(){}
    
    private String name;
    private String location;
    private int capacity;
    private String date;
    private String time;
    
    public Conference(String name, String location, int capacity, String date, String time){
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
