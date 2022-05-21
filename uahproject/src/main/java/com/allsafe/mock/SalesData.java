/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.mock;

import com.allsafe.model.Venta;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Rauld
 */
public class SalesData implements Serializable{
    /**
     * DOC
     * Clase Sales data encargada del almacenamiento de datos de ventas,
     * la clase sera de tipo Singleton, es decir solo requiere de una instanciacion en el 
     * codigo para su uso
     * 
     */
   
    private static SalesData instance = null;
    HashMap<String, Venta> SalesData = new HashMap<>();
    
    public HashMap<String, Venta> getSalesDataHashMap(){
       return(SalesData);
    
    }
    public void setHasMap(HashMap<String, Venta> has){
        
        this.SalesData = has;
    
    }
    
    private SalesData(){}
    
    public static SalesData getInstance(){
        if(instance == null){
            instance = new SalesData();
        }
        return instance;
    }
    
}
