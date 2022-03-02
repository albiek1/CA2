/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author albie
 */
@Entity
public class Speaker implements Serializable {

    @Id
    private Long id;
    
    public Speaker(){}
    
    private String name;
    private String profession;
    private String gender;
    
    /*@JoinTable(name="speaker_talk", joinColumns ={
    @JoinColumn(name="speaker_id", referencedColumnName="idspeaker")}, inverseJoinColumns ={
    @JoinColumn(name="talk_id", referencedColumnName="idtalk")})
    @ManyToMany*/
    
    public Speaker(String name, String profession, String gender){
        this.name = name;
        this.profession = profession;
        this.gender = gender;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getProfession(){
        return profession;
    }
    
    public void setProfession(String profession){
        this.profession = profession;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
