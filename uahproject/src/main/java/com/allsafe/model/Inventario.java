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

    public Inventario() {
        inventario = new ArrayList<>();
    }

    
    
    public ArrayList<Producto> getInventario() {
        return inventario;
    }
    
    public Producto getInventario(int a) {
        return inventario.get(a);
    }

    public void introducirProducto(Producto p, int cantidad){
           if (!inventario.contains(p)){
               inventario.add(p);
           }
           else {
               p.setStock(p.getStock()+ cantidad);  
           }
       }
    
    
    
}

