/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.mock;

import com.allsafe.model.Producto;
import com.allsafe.model.Usuario;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @author felixcentenera
 */
public class InventoryData {
    //Una instancia del objeto que va a existir
    private static  InventoryData  instance = null;
    HashMap<String, Producto> inventario = new HashMap<>();

// ********************************************************************************************************************     
    /**
     * 
     * @return  
     * <ul>
     *  <li> Intenventario  HashMap: Un HashMap cuya clave es el nombre del producto y el producto como valor</li>
     *  </ul>
     */
    public HashMap<String, Producto> getInventoryHashMap(){
       return inventario;
    }
// ******************************************************************************************************************** 


    
// ********************************************************************************************************************     
    //Evitamos la instanciacón directa. Constructor vacío.
    private InventoryData(){}
    /**
     *  Con este método obligamos a que cualquier servicio que requiera la intancia 
     * InventoryData, utilice únicamente una instancia que es común para todos.
     * @return
     *  <ul>
     *  <li> Instancia de la clase InventoryData: En caso de no existir, el método intancia la clase y se devuelve la misma generada.</li>
     *  </ul>
     */
    public static InventoryData getInstance(){
        if (instance ==null) {
            instance = new InventoryData();
        }
        return instance;
    }
// ******************************************************************************************************************** 
     
}
