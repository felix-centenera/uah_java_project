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
 
// ********************************************************************************************************************     
    /**
     * Nos devuelve un producto a partir de un su clave título.
     * @param titulo
     * @return
     */
    public static Producto getProducto(String titulo){
       Producto p1  = InventoryData.getInstance().getInventoryHashMap().get(titulo);
       return p1;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    // Método para añadir producto:
    /**
     * Nos permite añadir un producto al inventario, para ello se deben enviar los atributos que forman parte de un producto,
     * el producto se construirá y se añadira al inventario. Si el producto no existe actualmente en inventario, se 
     * incrementa el stock del producto.
     * Si se introduce correctamente el producto devuelve True, de lo contrario devuelva false.
     * 
     * @param titulo
     * @param caracteristicas
     * @param categoria
     * @param precio
     * @param fotografia
     * @param unidades
     * @return
     * <ul>
     * <li> True: Si el producto se ha añadido correctamente al inventario.</li>
     * <li> False: Si el producto no se ha añadido correctamente al inventario.</li>
     * </ul>
     */
    public static boolean addProduct(String titulo, String caracteristicas, String categoria, double precio, String fotografia, int unidades) {
        try {
            //Mirar si podemos annadir algun producto que no este repetido
            if ( !InventoryData.getInstance().getInventoryHashMap().containsKey(titulo) ) {
                InventoryData.getInstance().getInventoryHashMap().put(titulo,  new Producto(titulo, caracteristicas, categoria, precio, fotografia, unidades));
                //System.out.println (InventoryData.getInstance().getInventoryHashMap().toString());
                return true;
            }
            
            else {
                int stockActual= InventoryData.getInstance().getInventoryHashMap().get(titulo).getStock();
                InventoryData.getInstance().getInventoryHashMap().get(titulo).setStock(stockActual + unidades);
                //System.out.println (InventoryData.getInstance().getInventoryHashMap().toString());
                return true;
          
            }
          
            }  
            // UserData.getInstance().getUserHashMap().put(correo, u1);   
             
            catch (Exception e) {
               return false;   
           // JOptionPane.showMessageDialog(null, "Se ha introducido mal el producto reintentelo completando correctamente los campos", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
      }
// ********************************************************************************************************************     
    
 // ********************************************************************************************************************    
    // metodo borrar:
    /**
     * Nos permite borrar un producto del inventario, el producto ha borrar se identica por su clave título,
     * el cual es esperado por el método.
     * @param titulo
     * @return
     * <ul>
     * <li> True: Si el producto se ha borrado correctamente al inventario.</li>
     * <li> False: Si el producto no se ha borrado correctamente al inventario.</li>
     * </ul>
     * 
     */
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
 // ********************************************************************************************************************    
    
// ********************************************************************************************************************     
    // metodo borrar:
    /**
     * Nos permite recortar el stock de un producto dado por clave título. La cantidad de unidades
     * a recortar son esperadas como parametro del método.
     * @param titulo
     * @param stock
     * @return
     * <ul>
     * <li> True: Si el stock del producto se ha recortado correctamente.</li>
     * <li> False: Si el stock del producto no se ha recortado correctamente.</li>
     * </ul>
     */
    public static boolean deleteStockProduct(String titulo, int stock){
        //Eliminar producto teniendo la Key
        //inv.getInventario().remove(titulo);
        //InventoryData.getInstance().getInventoryHashMap().remove(titulo);
        
        if (  InventoryData.getInstance().getInventoryHashMap().containsKey(titulo)) {
            try {
                System.out.println("INFO: Voy a borrar: " + stock + " que son los que me has dicho,ahora mismo hay" );
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
   // ******************************************************************************************************************** 
    
  
 // ********************************************************************************************************************    
    /**
     * NOs permite añadir una opinión aun producto. Para ello se espera la clave titulo del producto, la calificación, comentario
     * y clave cliente para contruir la opinión y asociarla al producto.
     * @param titulo
     * @param calificacion
     * @param comentario
     * @param cliente
     * @return
     * <ul>
     * <li> True: Si la opinón se ha añadido correctamente al  producto.</li>
     * <li> False: Si la opinón no se ha añadido correctamente al  producto.</li>
     * </ul>
     */
    public static boolean addOpinionToAProducto(String titulo, int calificacion, String comentario, String cliente) {
            
            
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
  // ******************************************************************************************************************** 
    
  
// ********************************************************************************************************************     
    /**
     * Nos permite ordenar el inventario por la calificacion de estrellas de mayor puntuación a menor puntuación en función de una categoría,
     * atributo del producto y una clave título del producto que se usará para buscar coincidencias.
     * @param titulo
     * @param categoria
     * @return
     * <ul>
     * <li> ArrayList Producto: Nos devuelve el inventario en forma de arraylist de productos pertenecientes a una categoría.</li>
     * </ul>
     */
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
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite ordenar el inventario por la calificacion de estrellas de mayor puntuación a menor puntuación.
     * atributo del producto.
     * @return
     * <ul>
     * <li> ArrayList Producto: Nos devuelve el inventario en forma de arraylist de productos.</li>
     * </ul>
     */
    public static ArrayList<Producto>  orderByStarts() {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
    
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) ArrayCache
                .stream()
                .sorted(Comparator.comparingInt(Producto::getEstrella).reversed())
                .collect(Collectors.toList());
        return ordenadro;
     }
// ******************************************************************************************************************** 
    
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite ordenar el inventario por la calificacion de estrellas de mayor puntuación a menor puntuación en función de una categoría,
     * atributo del producto.
     * @param categoria
     * @return
     * <ul>
     * <li> ArrayList Producto: Nos devuelve el inventario en forma de arraylist de productos pertenecientes a una categoría.</li>
     * </ul>
     */
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
 // ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite ordenar el inventario por precio, de menor precio a mayor precio en función de una categoría,
     * atributo del producto y una clave título del producto que se usará para buscar coincidencias.
     * @param titulo
     * @param categoria
     * @return
     * <ul>
     * <li> ArrayList Producto: Nos devuelve el inventario en forma de arraylist de productos pertenecientes a una categoría.</li>
     * </ul>
     */
    public static ArrayList<Producto>  orderByLowtPrice(String titulo,String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
        
        ArrayList<Producto> arrayCacheFiltradoNombre = (ArrayList<Producto>) arrayCacheFiltradoCategoria.stream()
                .filter( v -> v.getTitulo().toLowerCase().contains(titulo.toLowerCase())).collect(Collectors.toList());
        
        
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoNombre
                .stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .collect(Collectors.toList());
                
        return ordenadro;
     }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite ordenar el inventario por precio, de menor precio a mayor precio en función de una categoría,
     * atributo del producto.
     * @param categoria
     * @return
     * <ul>
     * <li> ArrayList Producto: Nos devuelve el inventario en forma de arraylist de productos pertenecientes a una categoría.</li>
     * </ul>
     */
    public static ArrayList<Producto>  orderByLowtPrice(String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
        
        
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoCategoria
                .stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .collect(Collectors.toList());
                
        return ordenadro;
     }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite ordenar el inventario por precio, de mayor precio a menor precio en función de una categoría,
     * atributo del producto y una clave título del producto que se usará para buscar coincidencias.
     * @param titulo
     * @param categoria
     * @return
     * <ul>
     * <li> ArrayList Producto: Nos devuelve el inventario en forma de arraylist de productos pertenecientes a una categoría.</li>
     * </ul>
     */
    public static ArrayList<Producto>  orderByHighPrice(String titulo,String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
        
        ArrayList<Producto> arrayCacheFiltradoNombre = (ArrayList<Producto>) arrayCacheFiltradoCategoria.stream()
                .filter( v -> v.getTitulo().toLowerCase().contains(titulo.toLowerCase())).collect(Collectors.toList());
        
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoNombre
                .stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
         
        
        return ordenadro;
     }
 // ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Nos permite ordenar el inventario por precio, de mayor precio a menor precio en función de una categoría,
     * atributo del producto.
     * @param categoria
     * @return
     * <ul>
     * <li> ArrayList Producto: Nos devuelve el inventario en forma de arraylist de productos pertenecientes a una categoría.</li>
     * </ul>
     */
    public static ArrayList<Producto>  orderByHighPrice(String categoria) {
        HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> ArrayCache = new ArrayList<>(inv.values());
        
        ArrayList<Producto> arrayCacheFiltradoCategoria = (ArrayList<Producto>) ArrayCache.stream()
                .filter( v -> v.getCategoria().contentEquals(categoria)).collect(Collectors.toList());
      
        ArrayList<Producto> ordenadro = (ArrayList<Producto>) arrayCacheFiltradoCategoria
                .stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
         
        
        return ordenadro;
     }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite modificar la información de un producto del inventario. La clave título será 
     * utilizada para indentificar el producto a modificar.
     * @param titulo
     * @param caracteristicas
     * @param categoria
     * @param precio
     * @param fotografia
     * @param stock
     * @return
     * <ul>
     * <li> True: Si el producto se ha modificad correctamente en el inventario.</li>
     * <li> False: Si el producto no se ha modificad correctamente en el inventario.</li>
     * </ul>
     */
    public static boolean setProduct(String titulo, String caracteristicas, String categoria, double precio, String fotografia, int stock) {
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
                System.out.println("INFO: El producto ya no existe");
           return false;
       }
}
// ********************************************************************************************************************      
     

// ********************************************************************************************************************     
     /**
     * SERIALIZACION DE LOS ARCHIVOS. Los inventario se guardará en un fichero para su futura recuperación
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
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Nos permite recuperar la información del inventario desde un archivo local.
     */
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
 // ********************************************************************************************************************     
     
     
    
// ********************************************************************************************************************     
    // ORDENADO POR PRECIO MENOR NO SE UTILIZA. Se deja por historico en caso de que se quieran hacer pruebas con este algoritmo.
    /**
     *
     * @return
     * @deprecated Estos métodos han sido deprecados a favor de métodos mas eficientes.
     */
    public static ArrayList productsWithCheaperPrice() {
        //HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> arrayProductCheaper = bubbleAlgorithmPrice();
        Collections.reverse(arrayProductCheaper);
        return (arrayProductCheaper);
    }
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     *
     * @return
     * @deprecated Estos métodos han sido deprecados a favor de métodos mas eficientes.
     */
    public static ArrayList productsWithHightPrice() {
        //HashMap<String, Producto> inv  = InventoryData.getInstance().getInventoryHashMap();
        ArrayList<Producto> arrayProductCheaper = bubbleAlgorithmPrice();
        return (arrayProductCheaper);
    }
// ******************************************************************************************************************** 

    
// ********************************************************************************************************************     
    // ORDENADO POR PRECIO MAYOR

    /**
     *
     * @return
     * @deprecated Estos métodos han sido deprecados a favor de métodos mas eficientes.
     */
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

                int elemAct = (int) ArrayCache.get(j).getPrecio();
                int elemSig = (int) ArrayCache.get(j + 1).getPrecio();

                if (elemAct > elemSig) {

                    ArrayCacheKeys.set(j, ArrayCacheKeys.get(j + 1));
                    ArrayCacheKeys.set(j + 1, ArrayCacheKeys.get(j));

                }

            }

        }
        return(ArrayCacheKeys);
    }
// ********************************************************************************************************************     
    
       
}
