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
   
    //Una instancia del objeto que va a existir
    private static SalesData instance = null;
    HashMap<String, Venta> salesData = new HashMap<>();
    
    public HashMap<String, Venta> getSalesDataHashMap(){
       return(salesData);
    
    }
    
     //Evitamos la instanciacón directa. Constructor vacío.
    private SalesData(){}
    
    public static SalesData getInstance(){
        if(instance == null){
            instance = new SalesData();
        }
        return instance;
    }
   
    public void setHasMap(HashMap<String, Venta> has){
        
        this.salesData = has;
    
    }
    
    
    
    
    
}
