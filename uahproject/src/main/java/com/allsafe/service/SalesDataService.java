/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.InventoryData;
import com.allsafe.mock.SalesData;
import com.allsafe.model.Producto;
import com.allsafe.model.Venta;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    public static void SerializateSalesData() throws FileNotFoundException, IOException{
        //Vamos a Serializar el objeto SalesData en memoria no Volatil.
        /**
         * Se nos obliga a meter una exception
         */
        SalesData sales = SalesData.getInstance();
        ObjectOutputStream writtingDat = new ObjectOutputStream(new FileOutputStream("src/main/java/com/allsafe/localData/SalesDataLocal.dat"));
        writtingDat.writeObject(sales);
        writtingDat.close();
    
    }
    
    public static SalesData bringSalesSata() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream readingDat = new ObjectInputStream(new FileInputStream("src/main/java/com/allsafe/localData/SalesDataLocal.dat"));
        SalesData sales = (SalesData) readingDat.readObject();
        return(sales);
    }
    
    public static void generateSaleDocument(String id) throws IOException{
        //Generate document .txt
        
        FileWriter SaleFacture = new FileWriter("SalesFactures/" + id + ".txt");
        BufferedWriter bw = new BufferedWriter(SaleFacture);
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
        Venta vent = SalesData.getInstance().getSalesDataHashMap().get(id);
        String[] ProductSales = vent.getProductList().split("/");
        String ant = "";
        //SaleFacture.newLine();
        SaleFacture.write("_______________________________________________________________________________________________________________________\n");
        SaleFacture.write("FACTURA DE VENTA\n");
        SaleFacture.write("_______________________________________________________________________________________________________________________\n");
        SaleFacture.write("El Usuario " + vent.getUser() + " relalizo el pedido a AllSafe." + "                                            ID Factura: " +  vent.getID() +"\n");
        SaleFacture.write("                                                                                   Targeta de credito: " + vent.getTargetaCredito() +"\n");
        SaleFacture.write("                                                                                           A fecha de: " + vent.getDateConfirmedSale().format(formatoCorto) + "\n");
        SaleFacture.write("_______________________________________________________________________________________________________________________\n");
        SaleFacture.write("Lista de productos comprados.\n");
        SaleFacture.write("_______________________________________________________________________________________________________________________\n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        for(String i : ProductSales){
            if(ant.length() == i.length()){
                String[] arr = i.split(",");
                SaleFacture.write("Producto:       " + arr[0] + (SalesDataService.StringCreator(61)) + "Precio: " + arr[1] + "\n");
                ant = arr[0];
            }else if(ant.length() > i.length()){
                int carc = ant.length() - i.length();
                String[] arr = i.split(",");
                SaleFacture.write("Producto:       " + arr[0] + (SalesDataService.StringCreator(61 - carc)) + "Precio: " + arr[1] + "\n");
                ant = arr[0];

            }else if(ant.length() < i.length()){
                int carc = i.length() - ant.length();
                String[] arr = i.split(",");
                SaleFacture.write("Producto:       " + arr[0] + (SalesDataService.StringCreator(61 + carc)) + "Precio: " + arr[1] + "\n");
                ant = arr[0];

            }
                
        }
        SaleFacture.write("_______________________________________________________________________________________________________________________\n");
        SaleFacture.write("                                                                                                        Total: " + vent.getTotal() +"\n");
        SaleFacture.write("_______________________________________________________________________________________________________________________\n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write(" \n");
        SaleFacture.write("CONDICIONES Y FORMA DE PAGO\n");
        SaleFacture.write(" \n");
        SaleFacture.write("El pago podra realizarse en un plazo de 15 dias.\n");
        SaleFacture.write("AllSafe todos los derechos reservados\n");
        SaleFacture.write("_______________________________________________________________________________________________________________________\n");

        
        SaleFacture.close();
    }
    
    public static String StringCreator(int numero){
       String chart = "";
       for(int i = 0; i < numero; i++){
           chart = chart + " ";
       }
       return(chart);
    }
}
