/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.SalesData;
import com.allsafe.model.Venta;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author felixcentenera
 */
public class prueba {

    public static void main(String args[]) {
        
        List<String> listaCadenas = new ArrayList<String>();
        listaCadenas.add("hola");
        listaCadenas.add("hola2");
        listaCadenas.add("hola3");
        listaCadenas.add("hola3");
        listaCadenas.add("hola3");
        listaCadenas.add("hola3");
        listaCadenas.add("hola3");
        listaCadenas.add("hola3");

        listaCadenas.add("hola2");
        listaCadenas.add("hola3");
        listaCadenas.add("hola4");

        Stream<String> l1 = listaCadenas.stream().filter((cadena) -> cadena.equals("hola3"));
        System.out.println(l1.toList().toString());
                

    }

}
