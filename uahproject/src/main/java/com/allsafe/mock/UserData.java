/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.mock;

import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Direccion;
import com.allsafe.model.TarjetaDeCredito;
import com.allsafe.model.Token;
import com.allsafe.model.Usuario;
import com.allsafe.service.RadomGenerator;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 *
 * @author felixcentenera
 */
public class UserData {
    
    //Una instancia del objeto que va a existir
    private static  UserData  instance = null;
    HashMap<String, Usuario> usuarios = new HashMap<>();
    
    
    
    //Evitamos la instanciacón directa. Constructor vacío.
    private UserData(){}
    
     public static UserData getInstance(){
        if (instance ==null) {
            instance = new UserData();
        }
        return instance;
    }
    
     
     
     
    public  boolean checkUser(String correo,String clave) {
       //System.out.println("HOLA SOY USERDATA" + usuarios.get(correo).getClave());
        System.out.println(correo);
        System.out.println(clave);
       if (  usuarios.containsKey(correo)   ){
           System.out.println("INFO: He encontrado el correo entre los datos ");
           if (usuarios.get(correo).getClave().equals(clave)   ){
               System.out.println("INFO: La clave proporcionada es correcta");
               return true; 
           }
           else {
               System.out.println("INFO: La clave proporcionada no es correcta");
               return false; 
           }
       }
       else {
           System.out.println("INFO: No he encontrado el correo entre los datos ");
           return false;
       
       }
       
    }
 
     
    // Método para añadir usuarios.
    public boolean addUser(String dni, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
        
        try{
            System.out.println( dni + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
            usuarios.put(correo, u1);    
            System.out.println(usuarios.toString());
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            return false;
        }
    }
    
    
    //Metodo para crear un usuario de forma automatica sin formulario
    
     public  void createMockUser() {
         LocalDate fecha = LocalDate.of(2023, 9, 18); 
         LocalDateTime fechaTime = LocalDateTime.now();
         Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
         TarjetaDeCredito t1 = new TarjetaDeCredito("Manolo",1234_1234_1234_1234L,fecha);
         Direccion d1 = new Direccion("calleEjemplo",2,28829,"Madrid");
         ClienteParticular c1 = new ClienteParticular("20120000-F", "Manolo", d1,t1,"91-2240234","pass","felix",to1);
         usuarios.put("felix", c1);
    }
     
    public Usuario getUser(String correo,String clave){
       Usuario u1  = usuarios.get(correo);
       return u1;
    }
    
    public String TypeUser(String correo,String clave){
        Usuario u1  = usuarios.get(correo);
        String clase = usuarios.get(correo).getClass().getSimpleName();
        return clase;  
    }
  
}
