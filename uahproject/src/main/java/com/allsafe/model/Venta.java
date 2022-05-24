/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import com.allsafe.mock.InventoryData;
import com.allsafe.service.RadomGenerator;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Rauld
 */
public class Venta implements Serializable {
    private String ID;
    private LocalDateTime DateConfirmedSale;
    //HashMap<String, Integer> InShoppingCart;
    private String[] ProductList;
    private String user;
    private double Total;
    private long TarjetaCredito;

    
    /**INFORMACION ACERCA DEL ALMACENAMIENTO DE DATOS DE VENTA EN STRING
     * Se debera respetar el siguente formato
     * 
     * (Titulo producto),(numero de productos comprados)/(Titulo producto), (numero de productos comprados)
     * 
     * INFO: los parentesis son orientativos no pertences al formato
     * 
     * OBJETIVO:
     * Nos parece un gasto innecesario de memoria almacenar los productos en un arrayList o alguna estructura de datos debido a
     * que esto solo se va a leer para hacer la consulta de venta si realizar modificacion
     * 
     * @param ProductList
     * @param user
     * @param Total
     */
    
    
    //this.fechaEntradaTienda = LocalDateTime.now();
    
    public Venta(String[] ProductList, String user ,double Total, long TarjetaCredito) {
        this.ID = RadomGenerator.generateRandomPassword(20);
        this.DateConfirmedSale = LocalDateTime.now();
        this.ProductList = ProductList;
        this.user = user;
        this.Total = Total;
        this.TarjetaCredito = TarjetaCredito;
    }
    /**
     * @return ID. 
     * Getter*/
    public String getID() {
        return ID;
    }
    /**
     * @param ID 
     * Setter*/
    public void setID(String ID) {
        this.ID = ID;
    }
    /**
     * @return  DateConfirmedSale
     * Getter*/
    public LocalDateTime getDateConfirmedSale() {
        return DateConfirmedSale;
    }
    /**
     * @param DateConfirmedSale 
     * Setter*/
    public void setDateConfirmedSale(LocalDateTime DateConfirmedSale) {
        this.DateConfirmedSale = DateConfirmedSale;
    }
    /**
     * @param Total 
     * Setter*/
    public void setTotal(double Total){
        this.Total = Total;
    }
    /**
     * @return 
     * Getter*/
    public double getTotal(){
        return(Total);
    }
    /**
     * @return 
     * Getter*/
    public String getUser() {
        return user;
    }
    /**
     * @param user 
     * Setter*/
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * @return 
     * Getter*/

    public String[] getProductList() {
        return ProductList;
    }
    /**
     * @param ProductList
     * Setter*/

    public void setProductList(String[] ProductList) {
        this.ProductList = ProductList;
    }
    /**
     * @return 
     * Getter*/
    public long getTarjetaCredito() {
        return TarjetaCredito;
    }

//    public void setTargetaCredito(String TargetaCredito) {
//        this.TargetaCredito = TargetaCredito;
//    }

  

//    public String llenerateID() {
//        Random random = new Random();
//        String cad = "";
//
//        for (int i = 0; i < 10; i++) {
//            int randomInt = random.nextInt(48, 58);
//            char charac = (char) randomInt;
//
//            cad += charac;
//        }
//        return(cad);
//
//    }
//    
 
    /**
     * Se encarga de mostrarlo el contenido de los atributos del objeto
     */
    @Override
    public String toString() {
        return "Venta{" + "ID=" + ID + ", DateConfirmedSale=" + DateConfirmedSale + ", user=" + user + ", Total=" + Total + '}';
    }
    
    
    
    
}
