/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import java.util.ArrayList;

/**
 *
 * @author felixcentenera
 * @deprecated Este inventario puede utilizarse para pruebas, pero no debe usarse nunca como parte de la aplicación.
 * El inventario usado es InventoryData.
 */ 
@Deprecated
public class Inventario {
    
    
    private ArrayList<Producto> inventario;

    /**
     *
     */
    public Inventario() {
        inventario = new ArrayList<>();
    }

    
// ********************************************************************************************************************     
    /**
     * Nos devuelve el inventario, arrayList atributo  del inventario.
     * @return
     * <ul>
     * <li> ArrayList de productos inventario: inventario atributo de Inventario.</li>
     * </ul>
     */
    public ArrayList<Producto> getInventario() {
        return inventario;
    }
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Nos devuelve un producto en la posición indicada por el parametro que se recibe.
     * @param a
     * @return
     * <ul>
     * <li> Producto. Producto del inventario de la posición indicada en el parametro recibido.</li>
     * </ul>
     */
    public Producto getInventario(int a) {
        return inventario.get(a);
    }
// ******************************************************************************************************************** 
    
// ********************************************************************************************************************     
    /**
     * Nos permite introducir un producto en una cantidad indicada en el inventario
     * si y solo si este no se encuentra ya en el inventario, de lo contrario aumentará 
     * la cantidad del stock del producto en la cantidad indicada
     * @param p
     * @param cantidad
     */
    public void introducirProducto(Producto p, int cantidad){
           if (!inventario.contains(p)){
               inventario.add(p);
           }
           else {
               p.setStock(p.getStock()+ cantidad);  
           }
       }
// ********************************************************************************************************************     
}

