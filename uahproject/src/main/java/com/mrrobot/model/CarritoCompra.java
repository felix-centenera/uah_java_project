/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrrobot.model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author felixcentenera
 */
public class CarritoCompra {
    
    private int total = 0;
    private final String idCarrito;
    private static int generadorId =0;
    private ArrayList<Producto> productos;
    
    

    public CarritoCompra() {
        
        incrementaId(); 
        productos = new ArrayList<>();
        this.idCarrito = generadorId +"-"+ generateRandomNumber() ;
    }
    
    
    private static void incrementaId() {
        generadorId++;
    }
    
    public String getIdCarrito() {
        return idCarrito;
    }
    
    public int getTotal() {
        return total;
    }
    
    private int generateRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(0, 10000);
    }

    @Override
    public String toString() {
        return "CarritoCompra{" + "total=" + total + ", idCarrito=" + idCarrito + ", productos=" + productos + '}';
    }
    
    
   
    
}
