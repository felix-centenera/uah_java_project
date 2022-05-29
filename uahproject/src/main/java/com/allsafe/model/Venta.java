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
     * @param TarjetaCredito
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
     * Nos devuelve el ID  atributo de la venta. 
     * @return
     * <ul>
     * <li> String ID: ID atributo de la venta.</li>
     * </ul>
     */
    public String getID() {
        return ID;
    }

    /**
     * Nos permite etablecer el ID  atributo de Venta.
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Nos devuelve el DateConfirmedSale  atributo de la venta. 
     * @return
     * <ul>
     * <li> LocalDateTime DateConfirmedSale: DateConfirmedSale atributo de la venta.</li>
     * </ul>
     */
    public LocalDateTime getDateConfirmedSale() {
        return DateConfirmedSale;
    }

    /**
     * Nos permite etablecer el DateConfirmedSale  atributo de Venta.
     * @param DateConfirmedSale
     */
    public void setDateConfirmedSale(LocalDateTime DateConfirmedSale) {
        this.DateConfirmedSale = DateConfirmedSale;
    }

    /**
     * Nos permite etablecer el Total  atributo de Venta.
     * @param Total
     */
    public void setTotal(double Total){
        this.Total = Total;
    }

    /**
     * Nos devuelve el Total  atributo de la venta. 
     * @return
     * <ul>
     * <li> double Total: Total atributo de la venta.</li>
     * </ul>
     */
    public double getTotal(){
        return(Total);
    }

    /**
     * Nos devuelve el user  atributo de la venta. 
     * @return
     * <ul>
     * <li> String user: user atributo de la venta.</li>
     * </ul>
     */
    public String getUser() {
        return user;
    }

    /**
     * Nos devuelve el user  atributo de la venta. 
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Nos devuelve el ProductList  atributo de la venta. 
     * @return
     * <ul>
     * <li> String[] ProductList: ProductList atributo de la venta.</li>
     * </ul>
     */
    public String[] getProductList() {
        return ProductList;
    }

    /**
     * 
     * @param ProductList
     */
    public void setProductList(String[] ProductList) {
        this.ProductList = ProductList;
    }

    /**
     * Nos devuelve la TarjetaCredito  atributo de la venta. 
     * @return
     * <ul>
     * <li> long TarjetaCredito: TarjetaCredito atributo de la venta.</li>
     * </ul>
     */
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
     *
     * @return
     */
 

    @Override
    public String toString() {
        return "Venta{" + "ID=" + ID + ", DateConfirmedSale=" + DateConfirmedSale + ", user=" + user + ", Total=" + Total + '}';
    }
    
    
    
    
}
