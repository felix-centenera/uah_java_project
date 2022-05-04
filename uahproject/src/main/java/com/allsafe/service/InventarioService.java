/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**Por que debemos usar dos algoritmos de busqueda para la barra:
 *      Debemos usar la busqueda binaria cuando sabemos que el usuario con certeza sabe lo que busca , es decir 
 *      nos pone el nombre completo en el buscador, si no nos pone el nombre completo en el buscador entonces no.
 *      
 *      En el caso en que no nos ponga todo el resultado completo se usar un metodo mucho mas lento que sera la 
 *      busqueda secuencial que recorrera todo el inventario creando una lista de claves con todas las posibles 
 *      opciones que el usuario busca, muchos mas lenta pero cumple la funcion.
 */
package com.allsafe.service;

/**
 *
 * @author Rauld
 */
import com.allsafe.mock.Inventario;
import com.allsafe.model.Producto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import javax.swing.JOptionPane;

public class InventarioService {

    //    public static void rellenarInventario(){
    //    
    //    Usando el fichero, recorrerlo y coger los datos
    //    
    //    }

    //public static void refrescar Fichero

    //public static boolean comprobar que no hay rep
    
     
    public static void CreateProduct(String titulo, String caracteristicas, String categoria, int precio, String fotografia, int stock, Inventario inv) {

        //chequeamos cuantos objetos hay almacendos en inventario para ponerle nombre
        try {
            //Mirar si podemos annadir algun producto que no este repetido
            inv.setInventarioProd(titulo, new Producto(titulo, caracteristicas, categoria, precio, fotografia, stock));
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Se ha introducido mal el producto reintentelo completando correctamente los campos", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);

        }
    }
    public static void DeleteProduct(String nombre ,Inventario inv){
        //Eliminar producto teniendo la Key
        inv.getInventario().remove(nombre);
    }
    public static String findProductwithName(String Nombre, Inventario inv) {
        //encontrar Producto por nombre del objeto y retorna el objeto

        Set listInv = inv.getInventario().keySet();
        List<String> inven = new ArrayList<>(listInv);

        int num = inven.indexOf(Nombre);

        return (inven.get(num));

    }
    public static ArrayList findProductwithPrice(int p, Inventario inv){
        int index = 0;
        ArrayList<String> productKeys = new ArrayList<>();
        
        for(Producto pro: inv.getInventario().values()){
            if(pro.getPrecio() == p){
               Collection<Producto> colec = inv.getInventario().values();
               List<Producto> inven = new ArrayList<>(colec);
               index = inven.indexOf(pro);
               
               //convertimos a listas nuestros valores para reducir la complejidad agoritmica
               
               Set listKeysInv = inv.getInventario().keySet();
               List<String> invenKeys = new ArrayList<>(listKeysInv);
               
               //annadimos la keys 
               
               String key = invenKeys.get(index);
               productKeys.add(key);
            }
        }
        
        return(productKeys);
    }

    public static ArrayList findProductwithStock(int p, Inventario inv){
        int index = 0;
        ArrayList<String> productKeys = new ArrayList<>();
        
        for(Producto pro: inv.getInventario().values()){
            if(pro.getStock()== p){
               Collection<Producto> colec = inv.getInventario().values();
               List<Producto> inven = new ArrayList<>(colec);
               index = inven.indexOf(pro);
               
               //convertimos a listas nuestros valores para reducir la complejidad agoritmica
               
               Set listKeysInv = inv.getInventario().keySet();
               List<String> invenKeys = new ArrayList<>(listKeysInv);
               
               //annadimos la keys 
               
               String key = invenKeys.get(index);
               productKeys.add(key);
            }
        }
        
        return(productKeys);
    }    
    public static ArrayList findProductwithCategory(String categ, Inventario inv){
        /**
         * Al tener varios productos que pueden tener la misma categoria no podemos debolver
         * uniucamente un unico producto , hay que devolver mas de uno para que despues otra
         * funcion pueda pintarlos en el jFrame
         */
        int index = 0;
        ArrayList<String> productKeys = new ArrayList<>();
        
        for(Producto pro: inv.getInventario().values()){
            if(pro.getCategoria().equals(categ)){
               Collection<Producto> colec = inv.getInventario().values();
               List<Producto> inven = new ArrayList<>(colec);
               index = inven.indexOf(pro);
               
               //convertimos a listas nuestros valores para reducir la complejidad agoritmica
               
               Set listKeysInv = inv.getInventario().keySet();
               List<String> invenKeys = new ArrayList<>(listKeysInv);
               
               //annadimos la keys 
               
               String key = invenKeys.get(index);
               productKeys.add(key);
            }
        }
        
        return(productKeys);
    }
    public static ArrayList findProductwithStars(int stars , Inventario inv){
        
        int index = 0;
        ArrayList<String> productKeys = new ArrayList<>();
        
        for(Producto pro: inv.getInventario().values()){
            if(pro.getEstrella() == stars){
               Collection<Producto> colec = inv.getInventario().values();
               List<Producto> inven = new ArrayList<>(colec);
               index = inven.indexOf(pro);
               
               //convertimos a listas nuestros valores para reducir la complejidad agoritmica
               
               Set listKeysInv = inv.getInventario().keySet();
               List<String> invenKeys = new ArrayList<>(listKeysInv);
               
               //annadimos la keys 
               
               String key = invenKeys.get(index);
               productKeys.add(key);
            }
        }
        
        return(productKeys);
        
    }
    
    public static ArrayList findProductwithFecha(LocalDateTime date , Inventario inv){
        
        int index = 0;
        ArrayList<String> productKeys = new ArrayList<>();
        
        for(Producto pro: inv.getInventario().values()){
            if(pro.getFechaEntradaTienda().equals(date)){
               Collection<Producto> colec = inv.getInventario().values();
               List<Producto> inven = new ArrayList<>(colec);
               index = inven.indexOf(pro);
               
               //convertimos a listas nuestros valores para reducir la complejidad agoritmica
               
               Set listKeysInv = inv.getInventario().keySet();
               List<String> invenKeys = new ArrayList<>(listKeysInv);
               
               //annadimos la keys 
               
               String key = invenKeys.get(index);
               productKeys.add(key);
            }
        }
        
        return(productKeys);
        
    
    }
    
    //    funciones de busqueda de usuario barra de arriba
    //    utlizando nombre 
    
    public static boolean _busquedaPorNombre(String nombre, Inventario inv){
        /**
         * Si es true entonces desde la interfaz te rediriges a busqueda por nombre evitando asi una excepcion
         * 
         * 
         */
        return(inv.keySet().contains(nombre));
    }
    
    
//    public static ArrayList busquedaPorNombre(String nombre ,Invetario inv){
//        
//        if(_busquedaPorNombre(nombre , inv) == true){
//            
//            ArrayList<String> cacheProd = new ArrayList<>(inv.keySet());
//            ArrayList<String> cacheString = new ArrayList<>();
//            HashMap<String , ArrayList<String>> cacheInvOrdered = new HashMap<>();
//            String letterAnt = "";
//            //ordenamos el producto
//            Collections.sort(cacheProd);
//            
//            for(String prod: cacheProd){
//                
//                if(letterAnt.equals(nombre.charAt(0))){
//                    
//                    cacheString.add(prod);
//                }else if(cacheProd.indexOf(prod) == 0){
//                    
//                    cacheString.add(prod);
//                    letterAnt = "" + prod.charAt(0);
//                }else{
//                    cacheInvOrdered.put(letterAnt, cacheProd);
//                    cacheString.clear();
//                    
//                    cacheString.add(prod);
//                    letterAnt = "" + prod.charAt(0);
//                }
//                
//            }
//            
//            
//            
//            
//        }else{
//            
//            JOptionPane.showMessageDialog(null, "No se ha encontrado en el campo el producto deseado", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
//        
//        }
//        
//       
//    }
    
    
    //busquda de mayor a menor stock
    //busqueda de menor a mayor precio
    //
    public static ArrayList productsWithMorePrice(Inventario inv) {
        return (bubbleAlgorithmPrice(inv));
    }

    public static ArrayList productsWithCheaperPrice(Inventario inv) {
        ArrayList<Producto> I = bubbleAlgorithmPrice(inv);
        Collections.reverse(I);
        return (I);
    }
    public static ArrayList productsWithMinimalStock(Inventario inv){    
        ArrayList<Producto> I = bubbleAlgorithmStock(inv);
        Collections.reverse(I);
        return (I); 
    }
    public static ArrayList productsWithMaxStock(Inventario inv){
        return (bubbleAlgorithmStock(inv)); 
    }
    
            
    public static ArrayList bubbleAlgorithmStock(Inventario inv) {

        /**
         * Metodo de ordenacion en burbuja para mostrar los objetos del
         * inventario por mayor o menor precio
         */
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.getInventario().values());
        ArrayList<String> ArrayCacheKeys = new ArrayList<>(inv.getInventario().keySet());
        
        for (int i = 0; i < ArrayCache.size(); i++) {

            for (int j = 0; j < ArrayCache.size() - 1; j++) {

                int elemAct = ArrayCache.get(j).getStock();
                int elemSig = ArrayCache.get(j + 1).getStock();

                if (elemAct > elemSig) {

                    ArrayCacheKeys.set(j, ArrayCacheKeys.get(j + 1));
                    ArrayCacheKeys.set(j + 1, ArrayCacheKeys.get(j));

                }

            }

        }
        return(ArrayCache);

    }
    public static ArrayList bubbleAlgorithmPrice(Inventario inv) {

        /**
         * Metodo de ordenacion en burbuja para mostrar los objetos del
         * inventario por mayor o menor precio
         */
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.getInventario().values());
        ArrayList<String> ArrayCacheKeys = new ArrayList<>(inv.getInventario().keySet());
        
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

    public static ArrayList SearchAlgorithm(String name, Inventario inv) {
        /**
         * Metodo de busqueda de la barra de tarea, con reordenamiento
         */
        ArrayList<String> arrayCache = new ArrayList<>();

        for (String pro : inv.getInventario().keySet()) {
            /**
             * Comparamos los diferentes titulos teniendo en cuenta lo que ocupa
             * la otra palabra y los almacenamos en un arrayList
             */
            if (name.equals(pro.substring(0, name.length()))) {
                //si coincide el nombre con las palabras del principio lo almacenamos en un nuevo arrayList
                arrayCache.add(pro);
            }

        }
        return (arrayCache);
    }
    public static String binarySearchAlgorithm(String name, Inventario inv) {
        
        ArrayList<String> arrayCache = new ArrayList<>(inv.getInventario().keySet());
        int right = 0;
        int left = arrayCache.size();
        
        return(arrayCache.get(_binarySearchAlgorithm(name, arrayCache , right , left)));
            
        
    }
    
    public static int _binarySearchAlgorithm(String name, ArrayList n, int right, int left) {

        if (right > left) {
            return (-1);
        }
        int elemMiddle = (int) Math.floor((left + right) / 2);
        String MidStr = "" + n.get(elemMiddle);
        int resComp = name.compareTo(MidStr);

        if (resComp == 0) {

            return (elemMiddle);
        }

        if (resComp < 0) {

            return (_binarySearchAlgorithm(name, n, right, left - 1));

        } else {
            return (_binarySearchAlgorithm(name, n, right - 1, left));

        }

    }

}
