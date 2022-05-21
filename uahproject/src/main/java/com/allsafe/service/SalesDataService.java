/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.InventoryData;
import com.allsafe.mock.SalesData;
import com.allsafe.model.Producto;
import com.allsafe.model.Venta;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Rauld
 */
public class SalesDataService {
    
    
    public static boolean IsLocalDateTimeInDDBB(String loc){
        
        Collection<Venta> coleccion= SalesData.getInstance().getSalesDataHashMap().values();
        System.out.println(coleccion.toString());
        //IntStream.of(numbers).anyMatch(x -> x == numberToSearch)
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
        return(coleccion.stream().anyMatch(x -> x.getDateConfirmedSale().format(formatoCorto).equals(loc)));
    }
    
    public static Venta getSalesFounded(String loc){
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
        List<Venta>  list = SalesData.getInstance().getSalesDataHashMap().values().stream().filter(x -> x.getDateConfirmedSale().format(formatoCorto).equals(loc)).collect(Collectors.toList());
        System.out.println(list.toString());
        return(list.get(0));
//        ArrayList<String> arr = new ArrayList<>(SalesData.getInstance().getSalesDataHashMap().keySet());
//        ArrayList<String> cache = new ArrayList<>();
//        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
//        for(String i : arr){
//        
//            if(loc.equals(SalesData.getInstance().getSalesDataHashMap().get(i).getDateConfirmedSale().format(formatoCorto))){
//                
//                cache.add(i);
//            }
//        
//        }
//        System.out.println(cache);
//        return(SalesData.getInstance().getSalesDataHashMap().get(cache.get(0)));
//    
    }
    public static ArrayList<String> getAllSales(){
        ArrayList<String> arr = new ArrayList<>(SalesData.getInstance().getSalesDataHashMap().keySet());
        System.out.println(arr.toString());
        return(arr);
    }
    
    public static String[] SplittingProductList(String ProductList){
        
        return(ProductList.split("/"));
    
    
    }
    
}
