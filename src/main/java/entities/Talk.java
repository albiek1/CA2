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
public class Talk implements Serializable {

    @Id
    private Long id;
    
    public Talk(){}
    
    private String topic;
    private String duration;
    private String propslist;
    
    public Talk(String topic, String duration, String propslist){
        this.topic = topic;
        this.duration = duration;
        this.propslist = propslist;
    }
    
    public String getTopic(){
        return topic;
    }
    
    public void setTopic(String topic){
        this.topic = topic;
    }
    
    public String getDuration(){
        return duration;
    }
    
    public void setDuration(String duration){
        this.duration = duration;
    }
    
    public String getPropslist(){
        return propslist;
    }
    
    public void setPropslist(String propslist){
        this.propslist = propslist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
