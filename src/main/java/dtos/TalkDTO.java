/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import entities.Talk;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albie
 */
public class TalkDTO {
    private long id;
    private String topic;
    private String duration;
    private String propslist;
    
    public TalkDTO(String topic, String duration, String propslist){
        this.topic = topic;
        this.duration = duration;
        this.propslist = propslist;
    }
    
    public static List<TalkDTO> getDTOs(List<Talk> talks){
        List<TalkDTO> talkDTOs = new ArrayList<>();
        talks.forEach(tlk->talkDTOs.add(new TalkDTO(tlk)));
        return talkDTOs;
    }
    
    public TalkDTO(Talk tlk){
        if(tlk.getId() != null){
            this.id = tlk.getId();
        }
        this.topic = tlk.getTopic();
        this.duration = tlk.getDuration();
        this.propslist = tlk.getPropslist();
    }
    
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
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
    
    @Override
    public String toString(){
        return "Talk{"+"id="+id+", topic="+topic+", duration="+duration+", propslist="+propslist+'}';
    }
}
