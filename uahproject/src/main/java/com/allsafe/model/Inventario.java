/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import java.util.ArrayList;

/**
 *
 * @author felixcentenera
 */
public class Inventario {
    
    
    private ArrayList<Producto> inventario;
    /**
     * Contructor vacio de inventario
     */
    public Inventario() {
        inventario = new ArrayList<>();
    }

    
    /**
     * @return 
     * Getter */
    public ArrayList<Producto> getInventario() {
        return inventario;
    }
    /**
     * @param a
     * @return 
     * Getter */
    public Producto getInventario(int a) {
        return inventario.get(a);
    }
    /**
     * @param p
     * @param cantidad
     *  Inserta en el Inventario la cantidad de objeto y el producto
     */
    public void introducirProducto(Producto p, int cantidad){
           if (!inventario.contains(p)){
               inventario.add(p);
           }
           else {
               p.setStock(p.getStock()+ cantidad);  
           }
       }
    
    
    
}

