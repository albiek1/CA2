/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import entities.Speaker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albie
 */
public class SpeakerDTO {
    private long id;
    private String name;
    private String profession;
    private String gender;
    
    public SpeakerDTO(String name, String profession, String gender){
        this.name = name;
        this.profession = profession;
        this.gender = gender;
    }
    
    public SpeakerDTO(Speaker spk){
        if(spk.getId() != null){
            this.id = spk.getId();
        }
        this.name = spk.getName();
        this.profession = spk.getProfession();
        this.gender = spk.getGender();
    }
    
    public static List<SpeakerDTO> getDTOs(List<Speaker> spks){
        List<SpeakerDTO> speakerDTOs = new ArrayList<>();
        spks.forEach(spk->speakerDTOs.add(new SpeakerDTO(spk)));
        return speakerDTOs;
    }
    
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
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
    
    @Override
    public String toString(){
        return "Speaker{"+"id="+id+", name="+name+", profession="+profession+", gender="+gender+'}';
    }
}
