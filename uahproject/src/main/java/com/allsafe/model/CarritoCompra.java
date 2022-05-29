/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import com.allsafe.service.RadomGenerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author felixcentenera
 */
public class CarritoCompra implements Serializable{
    
    private int total = 0;
    private final String idCarrito;
    private static int generadorId =0;
    private ArrayList<Producto> productos;
    
    /**
     * Constructor.Genera un carrito de la compra. Este carrito además se le asigna un número indentificativo.
     */
    public CarritoCompra() {
        incrementaId(); 
        productos = new ArrayList<>();
        this.idCarrito = generadorId +"-" + RadomGenerator.generateRandomPassword(10);
    }

 // ******************************************************************************************************************** 
    /**
     * El método introduce el producto que recibe como paramétro en el ArrayList de productos del carrito 
     * @param producto
     * @return
     * <ul>
     *  <li> True:  Si ha sido capaz de añadir el producto al ArrayList de productos del carrito</li>
     *  <li> False: Si no ha sido capaz de añadir el producto al ArrayList de productos del carrito</li>
     * </ul>
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
// ******************************************************************************************************************** 

    
// ********************************************************************************************************************     
    /**
     *
     * El método elimina el producto que recibe como paramétro del ArrayList de productos del carrito 
     * @param producto
     * @return
     * <ul>
     *  <li> True:  Si ha sido capaz de eliminar el producto al ArrayList de productos del carrito</li>
     *  <li> False: Si no ha sido capaz de eliminar el producto al ArrayList de productos del carrito</li>
     * </ul>
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
 // ********************************************************************************************************************    
 
    
// ********************************************************************************************************************     
    private static void incrementaId() {
        generadorId++;
    }
    
    /**
     * El número o ID que inditica el carrito.
     * @return
     * <ul>
     *  <li> ID que indentifica el carrito</li>
     * </ul>
     */
    public String getIdCarrito() {
        return idCarrito;
    }
// ******************************************************************************************************************** 



// ********************************************************************************************************************     
    /**
     *
     * @return
     * <ul>
     * <li> Arraylist con todos los productos que contiene el carrito</li>
     * </ul>
     * 
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }
 // ******************************************************************************************************************** 
    
    
// ******************************************************************************************************************** 
    /**
     *
     * @return
     * <ul>
     * <li> Total del importe por los productos asociados al carrito</li>
     * </ul>
     * @deprecated El importe total por los productos del carrito es calculado en el método SalesData.ServiceSales, el cual utiliza SalesData.Services para este último fin, implmentado para la lógica de compra.
     */
    public int getTotal() {
        return total;
    }
// ********************************************************************************************************************     


// ********************************************************************************************************************     
//    /**
//     *
//     * Utilizado para generar un identificador asociado al carrito. Todo carrito esta asociado a un único usuario, por lo que es un número de refencia. La duplicidad sería posi
//     */
//    private int generateRandomNumber(){
//        Random rand = new Random();
//        return rand.nextInt(0, 10000);
//    }
// ********************************************************************************************************************   


    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "CarritoCompra{" + "total=" + total + ", idCarrito=" + idCarrito + ", productos=" + productos + '}';
    }
    
    
   
    
}
