/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import entities.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albie
 */
public class ItemDTO {
    private long id;
    private String str1;
    private String str2;
    
    public ItemDTO(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }
    
    public static List<ItemDTO> getDTOs(List<Item> itms){
        List<ItemDTO> itmsdtos = new ArrayList();
        itms.forEach(itm->itmsdtos.add(new ItemDTO(itm)));
        return itmsdtos;
    }
    
    public ItemDTO(Item itm){
        if(itm.getId() != null){
            this.id = itm.getId();
        }
        this.str1 = itm.getStr1();
        this.str2 = itm.getStr2();
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
    
    @Override
    public String toString(){
        return "ItemDTO{"+"id="+id+", str1="+str1+", str2="+str2+'}';
    }
}
