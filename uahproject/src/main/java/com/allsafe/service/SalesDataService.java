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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Rauld
 */
public class SalesDataService {

// ********************************************************************************************************************     
    /**
     * DEPRECATED FUNCTION
     * @param loc
     * @return 
     * @deprecated 
     */
    public static boolean IsLocalDateTimeInDDBB(LocalDateTime loc){
        
        Collection<Venta> coleccion= SalesData.getInstance().getSalesDataHashMap().values();
        
        //COMENTADO EL SIGUIENTE PRINT, VIGILAR Lógica:
        //System.out.println(coleccion.toString());
        //IntStream.of(numbers).anyMatch(x -> x == numberToSearch)
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
        return(coleccion.stream().anyMatch(x -> x.getDateConfirmedSale().equals(loc)));
    }
 // ******************************************************************************************************************** 
    
// ********************************************************************************************************************     
    /**
     * Nos devuelve la ventas encontradas HashMap de ventas que la fecha de las mismas
     * sea posterior a la indicada como parámetro de entrada.
     * @param loc
     * @return
     */
    public static  ArrayList getSalesFounded(LocalDateTime loc){
            //DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
            ArrayList<Venta> OrderedArray = new ArrayList<>(SalesData.getInstance().getSalesDataHashMap().values());
            //ArrayList<LocalDateTime> cache = new ArrayList<>();
            ArrayList<String> cache = new ArrayList<>();
            //int index = 0;
            OrderedArray.sort((d1,d2) -> d1.getDateConfirmedSale().compareTo(d2.getDateConfirmedSale()));
            
            //System.out.println("array ordenado: " + arr.toString());
            //System.out.println(arr.get(arr.size()-4).getDateConfirmedSale().format(formatoCorto));
            //System.out.println("");
            //arr.forEach(x -> cache.add(x.getDateConfirmedSale()));
            OrderedArray.stream().filter(x -> x.getDateConfirmedSale().isAfter(loc)).forEach(x -> cache.add(x.getID()));
            
//            for(LocalDateTime i : cache){
//                if(i.isBefore(loc)){
//                    index = cache.indexOf(i);
//                    arr1.add(arr.get(index).getID());
//                    
//                }
//            }
             
            //System.out.println(arr1);
            return(cache);
    }
 // ******************************************************************************************************************** 
    
    
// ******************************************************************************************************************** 
    /**
     * Nos devuelve todas las ventas del HashMap de ventas.
     * @return
     */
    public static ArrayList<String> getAllSales(){
        ArrayList<String> arr = new ArrayList<>(SalesData.getInstance().getSalesDataHashMap().keySet());
        //System.out.println(arr.toString());
        return(arr);
    }
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     *
     * @param ProductList
     * @return
     */
    public static String[] SplittingProductList(String ProductList){
        
        return(ProductList.split("/"));
    
    }
// ******************************************************************************************************************** 

// ********************************************************************************************************************     
    /**
     * Nos permite guardar en un fichero local SalesData para su posterior recuperación.
     * @throws FileNotFoundException
     * @throws IOException
     */
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
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite recuperar desde un fichero local toda la información de ventas.
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static SalesData bringSalesSata() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream readingDat = new ObjectInputStream(new FileInputStream("src/main/java/com/allsafe/localData/SalesDataLocal.dat"));
        SalesData sales = (SalesData) readingDat.readObject();
        return(sales);
    }
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Nos permite generar un documento de venta o factura a partir de una calve
     * Id de la venta.
     * @param id
     * @throws IOException
     */
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
        SaleFacture.write("Gastos de envío:       " + (SalesDataService.StringCreator(61)) + "Precio: " + "5"                                   + "\n");
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
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     *
     * @param numero
     * @return
     */
    public static String StringCreator(int numero){
       String chart = "";
       for(int i = 0; i < numero; i++){
           chart = chart + " ";
       }
       return(chart);
    }
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Permite la cuantía total de un ArrayList de productos añadiendo gastos de envío a
     * dicha cuantía.
     * @param listaProductos
     * @return
     * int total + GASTOS_DE_ENVIO 
     */
    public static double SumTotal(ArrayList<Producto> listaProductos){
        double total = 0;
        for (Producto p : listaProductos) {
            total+= p.getPrecio();
        }
        // Se añaden 5 euros de gastos de envío
        double GASTOS_DE_ENVIO =5;
        return total + GASTOS_DE_ENVIO;
    }
// ********************************************************************************************************************
    
    
    
// ********************************************************************************************************************     
    /**
     * Nos premite comprobar si de productos alojados el carrito de un  usuario recibio 
     * por parámetro, hay el suficiente stock en el inventario.
     * @param user
     * @return
     * <ul>
     * <li> True: Si el inventario contiene el stock suficiente de cada uno de los productos.</li>
     * <li> False: Si el inventario no contiene el stock suficiente de cada uno de los productos.</li>
     * </ul>
     */
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
// ******************************************************************************************************************** 
    
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite reducir el stock  del inventario de todos los productos que un usuario 
     * contiene en su carrito en función de las unidades solicitadas de cada producto.
     * @param user
     * @return
     * <ul>
     * <li> True: Si se ha recudizo correctamente el stock de cada producto en el inventario</li>
     * <li> False: Si no se ha recudizo correctamente el stock de cada producto en el inventario</li>
     * </ul>
     */
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
        
        //System.out.println(mapCarrito);
        
        for (String producto :  mapCarrito.keySet()) {
              if (! InventoryServices.deleteStockProduct(producto, mapCarrito.get(producto)))
                  return false;
        }
        System.out.println("INFO: Se han eliminado los productos vendidos del inventario");
        return true; 
    } 
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Nos permite gestionar la venta de un usuario, mediante el uso de otro métodos, comprobará
     * que hay stock suficiente para la venta, reducirá el stock del inventario en función de la venta, generará una venta 
     * añadiendola al Hashmap de ventas.
     * @param user
     * @return
     * <ul>
     * <li> True: Si todo el proceso de venta se ha realizado correctamente.</li>
     * <li> False: Si todo el proceso de venta no se ha realizado correctamente</li>
     * </ul>
     */
    public static boolean Sales(Usuario user){
        
        if ( CheckInventoryForSales(user)) { 
            System.out.println("INFO: Tenemos la cantidad suficiente del producto");
            
            ArrayList<Producto> listOfProducts  = UsersServices.getObjectShoppingCart(user);
            String[] ProductList = new String[ listOfProducts.size()];
            
            for (int i = 0; i < listOfProducts.size(); i++) {
                ProductList[i]= listOfProducts.get(i).getTitulo();
            } 
            double total= SumTotal(listOfProducts);
            
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
                            try {
                                generateSaleDocument(v1.getID());
                            } catch (IOException ex) {
                                Logger.getLogger(SalesDataService.class.getName()).log(Level.SEVERE, null, ex);
                                System.out.println("INFO: NO se ha podido generar la factura, contactar con Ventas");
                            }
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
 // ******************************************************************************************************************** 
    
    
    
// ********************************************************************************************************************     
    /**
     * SERIALIZACION DE LOS ARCHIVOS
     *  Permite la escritura en un fichero local para su futura recuperación de los datos
     * recogidos en el SalesDataHashMap
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
// ******************************************************************************************************************** 



// ********************************************************************************************************************     
    /**
     * Permite la recuperación de datos desde un fichero local.
     */
    public static void initSalesDataMock() {
        try {      
            FileInputStream fileInput = new FileInputStream("localDataMock/SalesDataLocal.dat");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);     
            try {
                HashMap<String, Venta> salesData = new HashMap<>();
                salesData = (HashMap)objectInput.readObject();
                SalesData.getInstance().getSalesDataHashMap().putAll(salesData);
                System.out.println("INFO : Se realiza la carga de Ventas");
                
                /*************************************************************************************************************************************/
                DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
//                System.out.println("*****************************************************************************************");
//                for(Venta a : SalesData.getInstance().getSalesDataHashMap().values()){
//
//                    System.out.println(a.getDateConfirmedSale().format(formatoCorto));
//
//
//
//                }
//
//                System.out.println("*****************************************************************************************");
                /*************************************************************************************************************************************/

    
    
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
// ********************************************************************************************************************     
   
    
}
