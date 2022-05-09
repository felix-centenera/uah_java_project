package com.allsafe.model;

import com.allsafe.model.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Rauld
 */
public class Test {

    public static void main(String args[]) {
        // Inicialización de objetos para pruebas:

//Fecha prueba.
        LocalDate fecha = LocalDate.of(2023, 9, 18);

//Crear producto
//(String titulo, String caracteristicas, String categoria, int precio, String fotografia, int stock)
        Producto p1 = new Producto("MacBookAirM1", "Apple", "Portatiles", 1000, "Img/laptops/macbook/appleMacbookAirM1.png", 1);
        Producto p2 = new Producto("MacBookProM1", "Apple", "Portatiles", 1000, "Img/laptops/macbook/appleMacbookProM1.png", 1);
        Producto p3 = new Producto("Dell XPS", "Dell", "Portatiles", 1000, "Img/laptops/dell/dellXps13.png", 1);

//Crear inventario y añadir productos a inventario
        Inventario i1 = new Inventario();

//Crear Dirección
//(String calle, int numero, int cp, String ciudad)
        Direccion d1 = new Direccion("calleEjemplo", 2, 28829, "Madrid");

//Crear TarjetaCredito
//(String nombreTitular, long numeroTarjetaCredito, LocalDate fechaCaducidad)
        TarjetaDeCredito t1 = new TarjetaDeCredito("Manolo", 1234_1234_1234_1234L, fecha);
        
//Crear clienteParticular
// (String dni, String nombre, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, String telefono, String clave, String correo)
//ClienteParticular c1 = new ClienteParticular("20120000-F", "Manolo", d1,t1,"91-2240234","pass","manolo@miempresa.com");
//Creacion del objeto User
        CarritoCompra c1 = new CarritoCompra();
        LocalDateTime hoy = LocalDateTime.now();
        Token token = new Token("wer" ,hoy );
//        Usuario usuario = new ClienteEmpresa(" 2", "sasd","2",c1 , d1 , t1 , "2" , "2" , "2" , token);
        
//        System.out.println("hola mundo" +usuario.getClave());
//        System.out.println(usuario);
//        

//        LocalDateTime hoy = LocalDateTime.now();
//
//        System.out.println("La fecha de hoy completa es: " + hoy);
//        // Cambiamos el formato 
//        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
//        System.out.println("Hoy es (formato corto)" + hoy.format(formatoCorto));
//        
//        LocalDateTime horaLimite = hoy.plusMinutes(4);
//        System.out.println("Hoy es (formato corto)1  " + horaLimite.format(formatoCorto));
//        //Establecemos una fecha 
//        
    }

}
