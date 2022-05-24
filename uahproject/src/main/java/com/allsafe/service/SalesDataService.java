/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.InventoryData;
import com.allsafe.mock.SalesData;
import com.allsafe.model.ClienteEmpresa;
import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Producto;
import com.allsafe.model.Usuario;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        FileWriter SaleFacture = new FileWriter("SalesInvoice/" + id + ".txt");//la ruta ha sido cambiada recientemente tener en cuenta
        BufferedWriter bw = new BufferedWriter(SaleFacture);
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
        Venta vent = SalesData.getInstance().getSalesDataHashMap().get(id);
        //String[] ProductSales = vent.getProductList().split("/");
        String[] ProductSales = vent.getProductList();
        //String ant = "";
        //SaleFacture.newLine();
        SaleFacture.write("_______________________________________________________________________________________________________________________\n");
        SaleFacture.write("FACTURA DE VENTA\n");
        SaleFacture.write("_______________________________________________________________________________________________________________________\n");
        SaleFacture.write("El Usuario " + vent.getUser() + " realizó el pedido a AllSafe." + "                                            ID Factura: " +  vent.getID() +"\n");
        SaleFacture.write("                                                                                   Tarjeta de crédito: " + vent.getTarjetaCredito() +"\n");
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
        for(String producto : ProductSales){
                SaleFacture.write("Producto:       " + producto + (SalesDataService.StringCreator(61)) + "Precio: " + InventoryServices.getProducto(producto).getPrecio()    + "\n");
//            if(ant.length() == i.length()){
//                //String[] arr = i.split(",");
//                SaleFacture.write("Producto:       " + i + (SalesDataService.StringCreator(61)) + "Precio: " + InventoryServices.getProducto(i).getPrecio()    + "\n");
//                ant = arr[0];
//            }else if(ant.length() > i.length()){
//                int carc = ant.length() - i.length();
//                String[] arr = i.split(",");
//                SaleFacture.write("Producto:       " + arr[0] + (SalesDataService.StringCreator(61 - carc)) + "Precio: " + arr[1] + "\n");
//                ant = arr[0];
//
//            }else if(ant.length() < i.length()){
//                int carc = i.length() - ant.length();
//                String[] arr = i.split(",");
//                SaleFacture.write("Producto:       " + arr[0] + (SalesDataService.StringCreator(61 + carc)) + "Precio: " + arr[1] + "\n");
//                ant = arr[0];
//
//            }
                
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
        SaleFacture.write("El pago podrá realizarse en un plazo de 15 días.\n");
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
    
    public static int SumTotal(ArrayList<Producto> listaProductos){
        int total = 0;
        for (Producto p : listaProductos) {
            total+= p.getPrecio();
        }
        
        return total;
    }
    
    
    public static boolean CheckInventoryForSales(Usuario user){
        
        ArrayList<Producto> listOfProducts  = UsersServices.getObjectShoppingCart(user);
        Map<String,Integer> mapCarrito = new HashMap();
        
        for (Producto producto : listOfProducts ){
            if (!mapCarrito.containsKey(producto.getTitulo()) ){
                mapCarrito.put(producto.getTitulo(), 1);
            }
            else {
                mapCarrito.put(producto.getTitulo(), mapCarrito.get(producto.getTitulo()) +1);
            }
        }
        
        for (String producto :  mapCarrito.keySet()) {
            if (InventoryServices.getProducto(producto).getStock() <  mapCarrito.get(producto) ) {
                return false;
            } 
        }
        return true; 
    }

    public static boolean SalesInventoryDepart(Usuario user){
        
        ArrayList<Producto> listOfProducts  = UsersServices.getObjectShoppingCart(user);
        Map<String,Integer> mapCarrito = new HashMap();
        
        for (Producto producto : listOfProducts ){
            if (!mapCarrito.containsKey(producto.getTitulo()) ){
                mapCarrito.put(producto.getTitulo(), 1);
            }
            else {
                mapCarrito.put(producto.getTitulo(), mapCarrito.get(producto.getTitulo()) +1);
            }
        }
        
        System.out.println(mapCarrito);
        
        for (String producto :  mapCarrito.keySet()) {
              if (! InventoryServices.deleteStockProduct(producto, mapCarrito.get(producto)))
                  return false;
        }
        System.out.println("INFO: Se han eliminado los productos vendidos del inventario");
        return true; 
    } 
    

    public static boolean Sales(Usuario user){
        
        if ( CheckInventoryForSales(user)) { 
            System.out.println("INFO: Tenemos la cantidad suficiente del producto");
            
            ArrayList<Producto> listOfProducts  = UsersServices.getObjectShoppingCart(user);
            String[] ProductList = new String[ listOfProducts.size()];
            
            for (int i = 0; i < listOfProducts.size(); i++) {
                ProductList[i]= listOfProducts.get(i).getTitulo();
            } 
            int total= SumTotal(listOfProducts);
            
            if (SalesInventoryDepart (user)){
                        if ((UsersServices.TypeUser(user.getCorreo(),user.getClave())).equals("ClienteParticular")) {
                            ClienteParticular c1 = (ClienteParticular) user;
                            Venta v1 = new Venta(ProductList,c1.getCorreo(), total, c1.getTarjetaDeCredito().getnumeroTarjetaCredito());
                            SalesData.getInstance().getSalesDataHashMap().put(v1.getID(), v1);
                            System.out.println("INFO: La compra se ha realizado con éxito");
                            
                            try {
                                generateSaleDocument(v1.getID());
                            } catch (IOException ex) {
                                Logger.getLogger(SalesDataService.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println("INFO: NO se ha podido generar la factura, contactar con Ventas");
                            }
                             
                            return true;

                        }
                        else{
                            ClienteEmpresa c1 = (ClienteEmpresa) user;
                            Venta v1 = new Venta(ProductList,c1.getCorreo(), total, c1.getTarjetaDeCredito().getnumeroTarjetaCredito());
                            SalesData.getInstance().getSalesDataHashMap().put(v1.getID(), v1);
                            System.out.println("INFO: La compra se ha realizado con éxito");
                            return true;
                        }
            }
            
            else {
                 System.out.println("INFO: La compra no se ha realizado con éxito, no ha sido posible eliminar los productos del inventario");
                 return false;
            }
                        
                        
        }
        else {
            System.out.println("INFO: No Tenemos la cantidad suficiente del producto");
            return false;
        }
    }
    
    
    /**
     * SERIALIZACION DE LOS ARCHIVOS
     */
    
    public static void saveSalesData() {
    //Vamos a Serializar el objeto SalesData en memoria no Volatil.
    /**
     * Se nos obliga a meter una exception
     */
    //UserData userDat = UserData.getInstance();
    try {
        FileOutputStream myFileOutStream = new  FileOutputStream ("localDataMock/SalesDataLocal.dat");
        ObjectOutputStream myObjectOutStream = new ObjectOutputStream(myFileOutStream);
        myObjectOutStream.writeObject(SalesData.getInstance().getSalesDataHashMap());
        
        myObjectOutStream.close();
        myFileOutStream.close();
        System.out.println("INFO: Se guardan las ventas" );
    }
    catch (IOException e){
                    System.out.println("Error:  No ha podido realizarse el guardado: " + e.toString()); 
                    
            }
    } 
    
    
    public static void initSalesDataMock() {
        try {      
            FileInputStream fileInput = new FileInputStream("localDataMock/SalesDataLocal.dat");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);     
            try {
                HashMap<String, Venta> salesData = new HashMap<>();
                salesData = (HashMap)objectInput.readObject();
                SalesData.getInstance().getSalesDataHashMap().putAll(salesData);
                System.out.println("INFO : Se realiza la carga de Ventas");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SalesDataService.class.getName()).log(Level.SEVERE, null, ex);
            }
            objectInput.close();
            fileInput.close();    
        }
        catch (IOException e){
                    System.out.println("Error:  No ha podido realizarse la recarga de ventas: " + e.toString()); 
            }
}
    
    
    
    
    
    
    
    
    
    
}
