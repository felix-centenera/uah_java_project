/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.mock;

import com.allsafe.model.Venta;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Rauld
 */
public class SalesData implements Serializable{
    /**
     * DOC
     * Clase Sales data encargada del almacenamiento de datos de ventas,
     * la clase sera de tipo Singleton, es decir solo requiere de una instanciacion en el 
     * codigo para su uso
     * 
     */
   
    //Una instancia del objeto que va a existir
    private static SalesData instance = null;
    HashMap<String, Venta> salesData = new HashMap<>();

// ********************************************************************************************************************     
    /**
     * 
     * @return
     * <ul>
     *  <li> salesData  HashMap: Un HashMap cuya clave es el ID de una compra y la compra como valor</li>
     *  </ul>
     */
    public HashMap<String, Venta> getSalesDataHashMap(){
       return (salesData);
    
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
     //Evitamos la instanciacón directa. Constructor vacío.
    private SalesData(){}
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     *  Con este método obligamos a que cualquier servicio que requiera la intancia SalesData, utilice únicamente una instancia que es común para todos.
     * @return
     * <ul>
     *  <li> Instancia de la clase SalesData: En caso de no existir, el método intancia la clase y se devuelve la misma generada.</li>
     *  </ul>
     */
    public static SalesData getInstance(){
        if(instance == null){
            instance = new SalesData();
        }
        return instance;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     *
     * @param has
     */
    public void setHasMap(HashMap<String, Venta> has){
        
        this.salesData = has;
    }
// ********************************************************************************************************************  
    
   
}
