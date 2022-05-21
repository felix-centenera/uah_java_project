/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import com.allsafe.mock.InventoryData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Rauld
 */
public class Venta {
    private String ID;
    private LocalDateTime DateConfirmedSale;
    //HashMap<String, Integer> InShoppingCart;
    private String ProductList;
    private String user;
    private double Total;
    private String TargetaCredito;

    
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
     * @param DateConfirmedSale
     * @param ProductList
     * @param user
     * @param Total
     */
    
    public Venta(LocalDateTime DateConfirmedSale,String ProductList, String user ,double Total, String TargetaCredito) {
        this.ID = llenerateID() ;
        this.DateConfirmedSale = DateConfirmedSale;
        this.ProductList = ProductList;
        this.user = user;
        this.Total = Total;
        this.TargetaCredito = TargetaCredito;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LocalDateTime getDateConfirmedSale() {
        return DateConfirmedSale;
    }

    public void setDateConfirmedSale(LocalDateTime DateConfirmedSale) {
        this.DateConfirmedSale = DateConfirmedSale;
    }
    public void setTotal(double Total){
        this.Total = Total;
    }
    public double getTotal(){
        return(Total);
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getProductList() {
        return ProductList;
    }

    public void setProductList(String ProductList) {
        this.ProductList = ProductList;
    }
    public String getTargetaCredito() {
        return TargetaCredito;
    }

    public void setTargetaCredito(String TargetaCredito) {
        this.TargetaCredito = TargetaCredito;
    }

  

    public String llenerateID() {
        Random random = new Random();
        String cad = "";

        for (int i = 0; i < 10; i++) {
            int randomInt = random.nextInt(48, 58);
            char charac = (char) randomInt;

            cad += charac;
        }
        return(cad);

    }
    
 

    @Override
    public String toString() {
        return "Venta{" + "ID=" + ID + ", DateConfirmedSale=" + DateConfirmedSale + ", user=" + user + ", Total=" + Total + '}';
    }
    
    
    
    
}
