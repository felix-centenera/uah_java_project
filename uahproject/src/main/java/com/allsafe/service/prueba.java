/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.InventoryData;
import com.allsafe.mock.SalesData;
import com.allsafe.mock.UserData;
import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Direccion;
import com.allsafe.model.Inventario;
import com.allsafe.model.Opinion;
import com.allsafe.model.Producto;
import com.allsafe.model.TarjetaDeCredito;
import com.allsafe.model.Token;
import com.allsafe.model.Usuario;
import com.allsafe.model.Venta;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author felixcentenera
 */
public class prueba {

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        try{
            LocalDateTime ahora = LocalDateTime.now();
            System.out.println("La fecha es " + ahora);

            String productList = "MacBookAirM1, 3/appleMacbookProM1, 213";

            Venta v1 = new Venta(ahora, productList, "Manolo", 12.0, "sdSDasdASDasdsa");

            HashMap<String, Venta> hash = new HashMap<>();

            hash.put(v1.getID(), v1);

            SalesData BBDDSales = SalesData.getInstance();
            BBDDSales.setHasMap(hash);

            System.out.println(Arrays.toString(BBDDSales.getSalesDataHashMap().keySet().toArray()));

            SalesDataService.generateSaleDocument(v1.getID());
        }catch(Exception e){
            System.out.println("No hemos encontrado nada de nada");
        
        }

    }

}
