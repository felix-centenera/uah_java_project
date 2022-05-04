package com.allsafe.mock;

import com.allsafe.model.Producto;
import java.util.HashMap;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rauld
 */
public class Inventario {
    /**
     * Clase singleton que sirve para instanciar una unica vez la clase
     * 
     */
    
    private HashMap<String ,Producto> inventario;
    private static Inventario instance = null;

    public Inventario() {}
    
    public static Inventario getInstance(){
        
        if(instance == null){
            instance = new Inventario();
        
        }
        return(instance);
    }
    public HashMap<String ,Producto> getInventario() {
        return inventario;
    }

    public void setInventario(HashMap<String ,Producto> inventario) {
        this.inventario = inventario;
        
    }
    public void setInventarioProd(String nombre ,Producto prod) {
        inventario.put(nombre, prod);
    }
    
    public Set keySet(){
        return(inventario.keySet());
    }
    @Override
    public String toString(){
        
        return("" + inventario);
    
    }
            
    
    
    
    
}
