package com.allsafe.service;


import com.allsafe.model.Producto;
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rauld
 */
public class Invetario {
    
    private HashSet<Producto> inventario;

    public Invetario() {
        this.inventario = new HashSet<>();
    }

    public HashSet<Producto> getInventario() {
        return inventario;
    }

    public void setInventario(HashSet<Producto> inventario) {
        this.inventario = inventario;
    }
    @Override
    public String toString(){
        
        return("" + inventario);
    
    }
            
    
    
    
    
}
