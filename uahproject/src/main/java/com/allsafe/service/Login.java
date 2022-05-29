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
    
// ********************************************************************************************************************     
    /**
     * Con este método obligamos a que cualquier servicio que requiera la intancia 
     * Login, utilice únicamente una instancia que es común para todos.
     * @return
     *  <ul>
     *  <li> Instancia de la clase Login: En caso de no existir, el 
     * método intancia la clase y se devuelve la misma generada.</li>
     *  </ul>
     */
    public static Login getInstance(){
        if (instance ==null) {
            instance = new Login();
        }
        return instance;
    }
  // ********************************************************************************************************************   
   
// ********************************************************************************************************************     
    //Métodos de login
    /**
     * Nos permite comprobar si el usuario esta o no logado en la plataforma.
     * Siempre que el intento de comprobación de login llegue sin parametros, se
     * rechaza el intenteo de autorización.
     * @return
     * <ul>
     * <li> False: Se devuelve falso rechazando cualquier intento de login sin parametros: </li>
     * </ul>
     */
    
    public boolean  checkLogin (){
        return false;
    }
 // ******************************************************************************************************************** 
    
// ********************************************************************************************************************     
    /**
     * Nos permite comprobar si el usuario esta o no logado en la plataforma. Si el usuario y la contraseña
     * son  correctos se asocia un token al usuario que tendrá una duración valida de 4 minutos.
     * @param correo
     * @param clave
     * @param ventana
     * @return
     * <ul>
     * <li> True: Se devuelve true si el usuario y password son correctos: </li>
     * <li> False: Se devuelve false si el usuario y password no son correctos: </li>
     * </ul>
     */
    public   boolean  checkLogin (String correo, String clave, Home ventana){         
         System.out.println(correo);
         //System.out.println(clave);
         if (UsersServices.checkUser(correo, clave )){
             System.out.println("INFO: Userdata store ha validado la información, y es correcta");
                 
                 Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
                 UsersServices.getUser(correo, clave).setToken(to1);
                 ventana.SetUsuario(UsersServices.getUser(correo, clave));
                 return true;
         }
         else {
            System.out.println("INFO: Userdata store ha validado la información, y  no  es correcta");
            return false;
         } 
    }
// ********************************************************************************************************************  
    
    
// ********************************************************************************************************************     
    /**
     *
     * Nos permite comprobar si el usuario esta o no logado en la plataforma. Si el usuario y contraseña son
     * correctos, se comprueba la expiración del token. De ser correcto todos los caso se devuelve True.
     * @param correo
     * @param clave
     * @param token
     * @return
     * <ul>
     * <li> True: Se devuelve true si el usuario,password son correctos y el token no ha expirado: </li>
     * <li> False: Se devuelve false si el usuario,password no son correctos o el token  ha expirado: </li>
     * </ul>
     */
    public   boolean  checkLogin (String correo, String clave,  Token token){
         if (UsersServices.checkUser(correo, clave )){
                 if (token.getFechaExpiracion().isAfter(LocalDateTime.now())){
                     System.out.println("INFO: El token es correcto");
                     return true;

                 }
                 else {
                    System.out.println("INFO: El token ha expirado");
                    return false;
                 }
         }
         else {
            System.out.println("INFO: Userdata store ha validado la información, y  no  es correcta");
            return false;
         } 
         
           //token.getFechaExpiracion().isAfter(LocalDateTime.now());   
    }
// ******************************************************************************************************************** 
    
    
}
