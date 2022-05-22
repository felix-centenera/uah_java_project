/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.mock;

import com.allsafe.model.Producto;
import com.allsafe.model.Usuario;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @author felixcentenera
 */
public class InventoryData {
    //Una instancia del objeto que va a existir
    private static  InventoryData  instance = null;
    HashMap<String, Producto> inventario = new HashMap<>();
    
    public HashMap<String, Producto> getInventoryHashMap(){
       return inventario;
    }
    
    
    //Evitamos la instanciacón directa. Constructor vacío.
    private InventoryData(){}
    
     public static InventoryData getInstance(){
        if (instance ==null) {
            instance = new InventoryData();
        }
        return instance;
    }
     
     
     
     
    
}
