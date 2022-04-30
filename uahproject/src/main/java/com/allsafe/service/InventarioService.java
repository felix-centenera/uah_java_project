/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

/**
 *
 * @author Rauld
 */
import com.allsafe.model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class InventarioService {
    
   
    
    
    public static void PaintHashMap(Invetario invent){
        //pintamos hasmap por consola
        HashSet<Producto> inv = invent.getInventario();
        
        for(Producto i : inv){
            
            System.out.println(i.toString());
        }

    }
    //public setInventoriaToTXT();
    //public getInventarioToObjetct();
    
    //pintar Inventario en la pantalla
    
    public static HashSet<Producto> busquedaProductosPorMayorStock(Invetario inv) {
        HashSet<Producto> StockOrdered = new HashSet<>();
        int[] arrayStock = new int[inv.getInventario().size()];
        
        int l =0;
        for(Producto i : inv.getInventario()){
            arrayStock[l] = i.getStock();
            l++;
        }
        
        Arrays.sort(arrayStock , 0 ,arrayStock.length);//mirar si esta ordenacion funciona
        
        for(int m = 0; m < arrayStock.length ; m++){
            for(Producto i : inv.getInventario()){
                
                if(i.getStock() == arrayStock[m]){
                
                    StockOrdered.add(i);
                }
            
            }
        
        }
        return(StockOrdered);
    } 
    
    public static HashSet<Producto> busquedaDeProductosPorPrecioMasBajos(Invetario inv){
        HashSet<Producto> PriceOrdered = new HashSet<>();
        int[] arrayPrice = new int[inv.getInventario().size()];
        
        int l =0;
        for(Producto i : inv.getInventario()){
            arrayPrice[l] = i.getPrecio();
            l++;
        }
        
        Arrays.sort(arrayPrice , 0 ,arrayPrice.length);//mirar si esta ordenacion funciona,Creo que hay que invertir
        
        for(int m = 0; m < arrayPrice.length ; m++){
            for(Producto i : inv.getInventario()){
                
                if(i.getStock() == arrayPrice[m]){
                
                    PriceOrdered.add(i);
                }
            
            }
        
        }
        return(PriceOrdered);
    
    
    }
    public static HashSet<Producto> BuscarProductosPorEstrellas(Invetario inv){
        HashSet<Producto> StarsOrdered = new HashSet<>();
        int[] ArrayStars = new int[inv.getInventario().size()];
        
        int l =0;
        for(Producto i : inv.getInventario()){
            ArrayStars[l] = i.getPrecio();
            l++;
        }
        
        Arrays.sort(ArrayStars , 0 ,ArrayStars.length);//mirar si esta ordenacion funciona
        
        for(int m = 0; m < ArrayStars.length ; m++){
            for(Producto i : inv.getInventario()){
                
                if(i.getStock() == ArrayStars[m]){
                
                    StarsOrdered.add(i);
                }
            
            }
        
        }
        return(StarsOrdered);
    }
    
    
            
            
        
        
        
        
        
        

    

}
