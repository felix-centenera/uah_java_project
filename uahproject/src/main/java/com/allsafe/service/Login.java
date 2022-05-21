/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.UserData;
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
    UserData userData = UserData.getInstance();
    
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
    
    public   boolean  checkLogin (String correo, String clave, Home ventana){         
         System.out.println(correo);
         System.out.println(clave);
         if (UsersServices.checkUser(correo, clave )){
             System.out.println("INFO: Userdata store ha validado la información, y es correcta");
                 ventana.SetUsuario(UsersServices.getUser(correo, clave)); 
                 Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
                 UsersServices.getUser(correo, clave).setToken(to1);
                 return true;
         }
         else {
            System.out.println("INFO: Userdata store ha validado la información, y  no  es correcta");
            return false;
         } 
    }
    
    
    
    public   boolean  checkLogin (String correo, String clave,  Token token){
         // todo // todo check user exists and information is correct and check token is correct
         if (token.getFechaExpiracion().isAfter(LocalDateTime.now())){
             System.out.println("INFO: El token es correcto");
             return true;

         }
         else {
            System.out.println("INFO: El token ha expirado");
            return false;
         }
           //token.getFechaExpiracion().isAfter(LocalDateTime.now());
         
    }

    
//     public   boolean  checkLogin (String correo, String clave){
//         // todo // todo check user exists and information is correct and check token is correct
//          System.out.println(correo);
//          System.out.println(clave);
//         if (userData.checkUser(correo, clave )){
//             System.out.println("INFO: Userdata store ha validado la información, y es correcta");
//             if (userData.TypeUser(correo, clave) == "ClienteParticular"){
//                 ClienteParticular c1 = userData.ReadUserClienteParticular(correo, clave);
//                 
//                 
//             }
//             return true;
//         }
//         else {
//            System.out.println("INFO: Userdata store ha validado la información, y  no  es correcta");
//            return false;
//         }
////          
////            
////            return true;
////         
//
//    }
     
//     public String TypeUser(String correo,String clave){
//       String clase =userData.TypeUser(correo, clave);
//       return clase;
//    }
    
    
}
