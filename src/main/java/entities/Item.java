/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author albie
 */
@Entity
@Table(name="ITEM")
public class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Item(){}
    
    private String str1;
    private String str2;
    
    public Item(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getStr1(){
        return str1;
    }
    
    public void setStr1(String str1){
        this.str1 = str1;
    }
    
    public String getStr2(){
        return str2;
    }
    
    public void setStr2(String str2){
        this.str2 = str2;
    }
}
