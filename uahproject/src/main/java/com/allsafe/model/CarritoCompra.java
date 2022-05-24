/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

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
    
    
    /**
     * Constructor vacio de Carrito de la Compra.
     */
    public CarritoCompra() {
        incrementaId(); 
        productos = new ArrayList<>();
        this.idCarrito = generadorId +"-"+ generateRandomNumber() ;
    }
    
    /**
     * 
     * @param producto
     * @return 
     * 
     * Retorna un booleano dependiendo de si hay disponibilidad primero
     */
    
    public boolean addToProducto(Producto producto){
        try{
            //TODO preguntar al inventario si hay disponibilidad primero
            productos.add(producto);
            return true;
        }
        catch (Exception e) {
            System.out.println("Error: No se ha podido añadir el producto al carrito " + e.toString()); 
            return false;
        }
    }
    /**
     * @param producto
     * @return boolean.
     * 
     * Retorna un boolean dependiendo de si se puede realizar la accion de eliminar producto o no.
     */
    public boolean deleteProducto(Producto producto){
        try{
            //TODO preguntar al inventario si hay disponibilidad primero
            productos.remove(producto);
            System.out.println("INFO: Se ha podido eliminar el producto al carrito "); 
            return true;
        }
        catch (Exception e) {
            System.out.println("Error: No se ha podido eliminar el producto al carrito " + e.toString()); 
            return false;
        }
    }
    
    
    
    
    private static void incrementaId() {
        generadorId++;
    }
    /**
     * @return idCarrito.
     * Getter
     */
    public String getIdCarrito() {
        return idCarrito;
    }
    /**
     * @return productos.
     * Getter
     */
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    /**
     * @return total.
     * Getter
     */
    public int getTotal() {
        return total;
    }
    /**
     * @return RandoNumber. 
     * Retorna un entero generado al Azar
     */
    private int generateRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(0, 10000);
    }
    
    /**
     * @return String. 
     * Retorna todos los atributos de la clase CarritoCompra
     */
    @Override
    public String toString() {
        return "CarritoCompra{" + "total=" + total + ", idCarrito=" + idCarrito + ", productos=" + productos + '}';
    }
    
    
   
    
}
