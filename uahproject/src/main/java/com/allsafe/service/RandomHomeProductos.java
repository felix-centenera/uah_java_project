/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.model.Inventario;
import com.allsafe.model.Producto;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author felixcentenera
 */
public class RandomHomeProductos {
    
    //private Inventario i;
    private RandomHomeProductos() {
    }
    
    public static ArrayList<Producto> seleccionarImagenes(Inventario i){
        ArrayList<Producto> RandomProductsHome = null;
        int lenghtInventario=i.getInventario().size();
        Random rand = new Random();
        for (int b=0; b <= 8; b++ ) {
            RandomProductsHome.add(i.getInventario(rand.nextInt(b, lenghtInventario)));
        }
        return RandomProductsHome;
    } 
}
