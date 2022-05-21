/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.SalesData;
import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Direccion;
import com.allsafe.model.Producto;
import com.allsafe.model.TarjetaDeCredito;
import com.allsafe.model.Token;
import com.allsafe.model.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author felixcentenera
 */
public class prueba {

    public static void main(String args[]) {
       String productList = "MacBookAirM1,3/appleMacbookProM1,213";
       String arr[] = productList.split("/");
       
        System.out.println(Arrays.toString(arr));
        
        //ArrayList<String> array = ArrayList<>(productList.split("/"));
    }

}
