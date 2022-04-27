/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Direccion;
import com.allsafe.model.TarjetaDeCredito;
import com.allsafe.model.Token;
import com.allsafe.model.Usuario;
import com.allsafe.ui.Home;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author felixcentenera
 */
public class Login {
    
    //private Home home;
    
    //Una instancia del objeto que va a existir
    private static  Login  instance = null;
    
    //Evitamos la instanciacón directa. Constructor vacío.
    private Login(){}
    
    public static Login getInstance(){
        if (instance ==null) {
            instance = new Login();
        }
        return instance;
    }
    
    
    //Métodos de login
    
    public boolean  checkLogin (){
        return false;
    }
    
    public   boolean  checkLogin (String clave, String correo, Home ventana){
        // todo check user exists and information is correct then:
        LocalDate fecha = LocalDate.of(2023, 9, 18);
        LocalDateTime fechaTime = LocalDateTime.now();
        Direccion d1 = new Direccion("calleEjemplo",2,28829,"Madrid");
        TarjetaDeCredito t1 = new TarjetaDeCredito("Manolo",1234_1234_1234_1234L,fecha);
        Token to3 = new Token("asdaskldjdasa",fechaTime);
        Usuario user = new ClienteParticular("20112sd0-F", "Félix", d1,t1,"91-2240234","pass","felix@miempresa.com",to3);
        ventana.SetUsuario(user);
        return true;
    }
    
    public   boolean  checkLogin (String clave, String correo, Token token){
         // todo // todo check user exists and information is correct and check token is correct
         if (token.getToken() == "asdaskldjdasa"){
             System.out.println("INFO: El token esta bien");
             return true;
         
         }
         else {
            System.out.println("INFO: El token esta bien");
            return false;
         }
         
    }   
}
