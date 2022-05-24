/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.InventoryData;
import com.allsafe.mock.UserData;
import com.allsafe.model.Inventario;
import com.allsafe.model.Opinion;
import com.allsafe.model.Producto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author felixcentenera
 */
public class InventoryServices {
    
    
    
    public static Producto getProducto(String titulo){
       Producto p1  = InventoryData.getInstance().getInventoryHashMap().get(titulo);
       return p1;
    }
    
    // Método para añadir producto:
    public static boolean addProduct(String titulo, String caracteristicas, String categoria, int precio, String fotografia, int unidades) {
        try {
            //Mirar si podemos annadir algun producto que no este repetido
            if ( !InventoryData.getInstance().getInventoryHashMap().containsKey(titulo) ) {
                InventoryData.getInstance().getInventoryHashMap().put(titulo,  new Producto(titulo, caracteristicas, categoria, precio, fotografia, unidades));
                System.out.println (InventoryData.getInstance().getInventoryHashMap().toString());
                return true;
            }
            
            else {
                int stockActual= InventoryData.getInstance().getInventoryHashMap().get(titulo).getStock();
                InventoryData.getInstance().getInventoryHashMap().get(titulo).setStock(stockActual + unidades);
                System.out.println (InventoryData.getInstance().getInventoryHashMap().toString());
                return true;
          
            }
          
            }  
            // UserData.getInstance().getUserHashMap().put(correo, u1);   
             
            catch (Exception e) {
               return false;   
           // JOptionPane.showMessageDialog(null, "Se ha introducido mal el producto reintentelo completando correctamente los campos", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
      }
    
    
    // metodo borrar:
    public static boolean deleteProduct(String titulo){
        //Eliminar producto teniendo la Key
        //inv.getInventario().remove(titulo);
        //InventoryData.getInstance().getInventoryHashMap().remove(titulo);
        
        if (  InventoryData.getInstance().getInventoryHashMap().containsKey(titulo)) {
            try {
                InventoryData.getInstance().getInventoryHashMap().remove(titulo);
                return true;
            }
            catch (Exception e){
                System.out.println("Error: No se ha podido eliminar al producto: " + e.toString()); 
               return false;
            }
        }
        else {
           return false;
       }
    }
    
    
    // metodo borrar:
    public static boolean deleteStockProduct(String titulo, int stock){
        //Eliminar producto teniendo la Key
        //inv.getInventario().remove(titulo);
        //InventoryData.getInstance().getInventoryHashMap().remove(titulo);
        
        if (  InventoryData.getInstance().getInventoryHashMap().containsKey(titulo)) {
            try {
                System.out.println("Voy a borrar: " + stock + " que son los que me has dicho,ahora mismo hay" );
                int currentlyStock = InventoryData.getInstance().getInventoryHashMap().get(titulo).getStock();
                InventoryData.getInstance().getInventoryHashMap().get(titulo).setStock( currentlyStock - stock);
                return true;
            }
            catch (Exception e){
                System.out.println("Error: No se ha podido modificar el stock al producto: " + e.toString()); 
               return false;
            }
        }
        else {
           return false;
       }
    }
    
    
    
    
    
    public static boolean addOpinionToAProducto(String titulo, int calificacion, String comentario, String cliente) {
            System.out.println("hola");
            
            if (  InventoryData.getInstance().getInventoryHashMap().containsKey(titulo)) {
            try {
                
                //Producto p1  = InventoryData.getInstance().getInventoryHashMap().get(titulo);
                Opinion o1 = new Opinion(calificacion, comentario, cliente);
                InventoryData.getInstance().getInventoryHashMap().get(titulo).introducirOpinion(o1);
                //p1.introducirOpinion(o1);
                return true;
            }
            catch (Exception e){
                System.out.println("Error: No se ha podido eliminar al producto: " + e.toString()); 
               return false;
            }
        }
        else {
           return false;
       }
           
    }
  
  
     public static ArrayList<Producto>  orderByStarts(String titulo, String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
        
        ArrayList<Producto> arrayCacheFiltradoNombre = (ArrayList<Producto>) arrayCacheFiltradoCategoria.stream()
                .filter( v -> v.getTitulo().toLowerCase().contains(titulo.toLowerCase())).collect(Collectors.toList());
        
        
//        ArrayList<Producto> arrayCacheFiltradoNombre = (ArrayList<Producto>) ArrayCache.stream()
//                .filter( v -> v.getCategoria().toUpperCase().contains(categoria)).collect(Collectors.toList());
                
        
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoNombre
                .stream()
                .sorted(Comparator.comparingInt(Producto::getEstrella).reversed())
                .collect(Collectors.toList());
                
        return ordenadro;
     }
     
     public static ArrayList<Producto>  orderByStarts() {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
    
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) ArrayCache
                .stream()
                .sorted(Comparator.comparingInt(Producto::getEstrella).reversed())
                .collect(Collectors.toList());
        return ordenadro;
     }
     
     
     
     public static ArrayList<Producto>  orderByStarts(String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
        
    
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoCategoria
                .stream()
                .sorted(Comparator.comparingInt(Producto::getEstrella).reversed())
                .collect(Collectors.toList());
        
        
        return ordenadro;
     }
 
  
  
     public static ArrayList<Producto>  orderByLowtPrice(String titulo,String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
        
        ArrayList<Producto> arrayCacheFiltradoNombre = (ArrayList<Producto>) arrayCacheFiltradoCategoria.stream()
                .filter( v -> v.getTitulo().toLowerCase().contains(titulo.toLowerCase())).collect(Collectors.toList());
        
        
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoNombre
                .stream()
                .sorted(Comparator.comparingInt(Producto::getPrecio))
                .collect(Collectors.toList());
                
        return ordenadro;
     }
     
     
     public static ArrayList<Producto>  orderByLowtPrice(String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
        
        
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoCategoria
                .stream()
                .sorted(Comparator.comparingInt(Producto::getPrecio))
                .collect(Collectors.toList());
                
        return ordenadro;
     }
     
     
     
     public static ArrayList<Producto>  orderByHighPrice(String titulo,String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
        
        ArrayList<Producto> arrayCacheFiltradoNombre = (ArrayList<Producto>) arrayCacheFiltradoCategoria.stream()
                .filter( v -> v.getTitulo().toLowerCase().contains(titulo.toLowerCase())).collect(Collectors.toList());
        
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoNombre
                .stream()
                .sorted(Comparator.comparingInt(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
         
        
        return ordenadro;
     }
     
      public static ArrayList<Producto>  orderByHighPrice(String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
      
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoCategoria
                .stream()
                .sorted(Comparator.comparingInt(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
         
        
        return ordenadro;
     }
     
     
     
     
     
     
     public static boolean setProduct(String titulo, String caracteristicas, String categoria, int precio, String fotografia, int stock) {
            if (  InventoryData.getInstance().getInventoryHashMap().containsKey(titulo)) {
            try {
                
                Producto p1 = (Producto) InventoryData.getInstance().getInventoryHashMap().get(titulo);
                p1.setTitulo(titulo);
                p1.setCaracteristicas(caracteristicas);
                p1.setCategoria(categoria);
                p1.setPrecio(precio);
                p1.setFotografia(fotografia);
                p1.setStock(stock);
              
                return true;
            }
            catch (Exception e){
                System.out.println("Error: No se ha podido modificar el producto: " + e.toString()); 
               return false;
            }
        }
        else {
                System.out.println("INFO: el producto ya no existe");
           return false;
       }

}
     
     
     
     
     
     
     
     
     
    
    
    
     
     
     
     
     
     
     
     
     
     
     
     
    
    // ORDENADO POR PRECIO MENOR NO SE UTILIZA. Se deja por historico en caso de que se quieran hacer pruebas con este algoritmo.
    public static ArrayList productsWithCheaperPrice() {
        //HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> arrayProductCheaper = bubbleAlgorithmPrice();
        Collections.reverse(arrayProductCheaper);
        return (arrayProductCheaper);
    }
    
    public static ArrayList productsWithHightPrice() {
        //HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> arrayProductCheaper = bubbleAlgorithmPrice();
        return (arrayProductCheaper);
    }
    
    
   
    
    
    
    
    
    // ORDENADO POR PRECIO MAYOR
    public static ArrayList bubbleAlgorithmPrice() {
        
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();

        /**
         * Metodo de ordenacion en burbuja para mostrar los objetos del
         * inventario por mayor o menor precio
         */
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        ArrayList<String> ArrayCacheKeys = new ArrayList<>(inv.keySet());
        
        for (int i = 0; i < ArrayCache.size(); i++) {

            for (int j = 0; j < ArrayCache.size() - 1; j++) {

                int elemAct = ArrayCache.get(j).getPrecio();
                int elemSig = ArrayCache.get(j + 1).getPrecio();

                if (elemAct > elemSig) {

                    ArrayCacheKeys.set(j, ArrayCacheKeys.get(j + 1));
                    ArrayCacheKeys.set(j + 1, ArrayCacheKeys.get(j));

                }

            }

        }
        return(ArrayCacheKeys);
    }
    
    /**
     * SERIALIZACION DE LOS ARCHIVOS
     */
    
    public static void saveInventoryData() {
    //Vamos a Serializar el objeto SalesData en memoria no Volatil.
    /**
     * Se nos obliga a meter una exception
     */
    //UserData userDat = UserData.getInstance();
    try {
        FileOutputStream myFileOutStream = new  FileOutputStream ("localDataMock/InventoryDataLocal.dat");
        ObjectOutputStream myObjectOutStream = new ObjectOutputStream(myFileOutStream);
        myObjectOutStream.writeObject(InventoryData.getInstance().getInventoryHashMap());
        
        myObjectOutStream.close();
        myFileOutStream.close();
        System.out.println("INFO: Se guarda el inventario" );
    }
    catch (IOException e){
                    System.out.println("Error:  No ha podido realizarse el guardado: " + e.toString()); 
                    //jPanelUsersFound.setVisible(false);
            }
    } 
    
    
    public static void initInventoryDataMock() {
        try {      
            FileInputStream fileInput = new FileInputStream("localDataMock/InventoryDataLocal.dat");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);     
            try {
                HashMap<String, Producto> inventario = new HashMap<>();
                inventario = (HashMap)objectInput.readObject();
                InventoryData.getInstance().getInventoryHashMap().putAll(inventario);
                System.out.println("INFO : Se realiza la carga de inventario");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InventoryServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            objectInput.close();
            fileInput.close();    
        }
        catch (IOException e){
                    System.out.println("Error:  No ha podido realizarse la recarga de inventario: " + e.toString()); 
            }
}
    
    
    
}
