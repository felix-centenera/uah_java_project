/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.mock;

import com.allsafe.model.Administrador;
import com.allsafe.model.ClienteEmpresa;
import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Direccion;
import com.allsafe.model.TarjetaDeCredito;
import com.allsafe.model.Token;
import com.allsafe.model.Usuario;
import com.allsafe.service.RadomGenerator;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 *
 * @author felixcentenera
 */
public class UserData implements Serializable{
    
    //Una instancia del objeto que va a existir
    private static  UserData  instance = null;
    HashMap<String, Usuario> usuarios = new HashMap<>();
    
    public HashMap<String, Usuario> getUserHashMap(){
       return usuarios;
    }
    
    
    //Evitamos la instanciacón directa. Constructor vacío.
    private UserData(){}
    
     public static UserData getInstance(){
        if (instance ==null) {
            instance = new UserData();
        }
        return instance;
    }
    
     
     
     
//    public  boolean checkUser(String correo,String clave) {
//       //System.out.println("HOLA SOY USERDATA" + usuarios.get(correo).getClave());
//        System.out.println(correo);
//        //System.out.println(clave);
//       if (  usuarios.containsKey(correo)   ){
//           System.out.println("INFO: He encontrado el correo entre los datos ");
//           if (usuarios.get(correo).getClave().equals(clave)   ){
//               System.out.println("INFO: La clave proporcionada es correcta");
//               return true; 
//           }
//           else {
//               System.out.println("INFO: La clave proporcionada no es correcta");
//               return false; 
//           }
//       }
//       else {
//           System.out.println("INFO: No he encontrado el correo entre los datos ");
//           return false;
//       
//       }
//       
//    }
 
     
    // Método para añadir usuarios clientes particulares.
//    public boolean addUser(String dni, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
//        if (!usuarios.containsKey(correo)){
//        try{
//            System.out.println( dni + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
//            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
//            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
//            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
//            usuarios.put(correo, u1);    
//            System.out.println(usuarios.toString());
//            return true;
//        }catch (Exception ex) {
//            System.out.println("Error: " + ex.toString()); 
//            return false;
//        }
//    
//        }
//        else {
//            System.out.println("Error: El usuario ya existe"); 
//            return false;
//        
//        }
//    }
    
    
//     public boolean addAdmin(String clave, String correo){
//        if (!usuarios.containsKey(correo)){
//        try{
//            System.out.println( clave + correo);
//            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//            Usuario a1 = new Administrador(clave, correo, to1);
//            usuarios.put(correo, a1);    
//            System.out.println(usuarios.toString());
//            return true;
//        }catch (Exception ex) {
//            System.out.println("Error: " + ex.toString()); 
//            return false;
//        }
//    
//        }
//        else {
//            System.out.println("Error: El usuario ya existe"); 
//            return false;
//        
//        }
//    }
    
        // Método para añadir usuarios clientes particulares.
//    public boolean setUser(String dni, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
//        if (usuarios.containsKey(correo)){
//        try{
//            System.out.println( dni + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
////            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
////            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
////            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
////            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
////            usuarios.put(correo, u1);    
//            
//            ClienteParticular c1 = (ClienteParticular) usuarios.get(correo);
//            c1.setDni(dni);
//            c1.setNombre(nombre);
//            c1.getDireccion().setCalle(direccionCalle);
//            c1.getDireccion().setCiudad(direccionCiudad);
//            c1.getDireccion().setNumero(direccionNumero);
//            c1.getDireccion().setCp(direccionCP);
//            c1.getTarjetaDeCredito().setNumeronumeroTarjetaCredito(tarjetaDeCreditoNumero);
//            c1.getTarjetaDeCredito().setNombreTitular(tarjetaDeCreditoTitular);
//            c1.getTarjetaDeCredito().setFechaCaducidad(tarjetaDeCreditoCaducidad);
//            c1.setTelefono(telefono);
//            c1.setClave(clave);
//            
//            System.out.println(usuarios.toString());
//            return true;
//        }catch (Exception ex) {
//            System.out.println("Error: " + ex.toString()); 
//            return false;
//        }
//    
//        }
//        else {
//            System.out.println("Error: El usuario no  existe"); 
//            return false;
//        
//        }
//    }
    
    
    
//     public boolean setUser(String cif,String web, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
//        if (usuarios.containsKey(correo)){
//        try{
//            System.out.println( cif + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
////            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
////            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
////            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
////            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
////            usuarios.put(correo, u1);    
//            
//            ClienteEmpresa c1 = (ClienteEmpresa) usuarios.get(correo);
//            c1.setCif(cif);
//            c1.setWeb(web);
//            c1.setNombre(nombre);
//            c1.getDireccion().setCalle(direccionCalle);
//            c1.getDireccion().setCiudad(direccionCiudad);
//            c1.getDireccion().setNumero(direccionNumero);
//            c1.getDireccion().setCp(direccionCP);
//            c1.getTarjetaDeCredito().setNumeronumeroTarjetaCredito(tarjetaDeCreditoNumero);
//            c1.getTarjetaDeCredito().setNombreTitular(tarjetaDeCreditoTitular);
//            c1.getTarjetaDeCredito().setFechaCaducidad(tarjetaDeCreditoCaducidad);
//            c1.setTelefono(telefono);
//            c1.setClave(clave);
//            
//            System.out.println(usuarios.toString());
//            return true;
//        }catch (Exception ex) {
//            System.out.println("Error: " + ex.toString()); 
//            return false;
//        }
//    
//        }
//        else {
//            System.out.println("Error: El usuario no  existe"); 
//            return false;
//        
//        }
//    }
     
     
//     public boolean setUser(String clave, String correo){
//        if (usuarios.containsKey(correo)){
//        try{
//            System.out.println( clave + correo);
////            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
////            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
////            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
////            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
////            usuarios.put(correo, u1);    
//            usuarios.get(correo).setClave(clave);
//            System.out.println(usuarios.toString());
//            return true;
//        }catch (Exception ex) {
//            System.out.println("Error: " + ex.toString()); 
//            return false;
//        }
//    
//        }
//        else {
//            System.out.println("Error: El usuario no  existe"); 
//            return false;
//        
//        }
//    }
    
    
    
    
    
    
    
    
    // Método para añadir usuarios clientes empresa. String cif, String web
//    public boolean addUser(String cif, String web, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
//        
//        if (!usuarios.containsKey(correo)){
//        try{
//            System.out.println( cif + nombre + web + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
//            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
//            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
//            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//            Usuario u1 = new ClienteEmpresa(cif, web, nombre, d1,t1,telefono,clave,correo,to1);
//            usuarios.put(correo, u1);    
//            System.out.println(usuarios.toString());
//            return true;
//        }catch (Exception ex) {
//            System.out.println("Error: " + ex.toString()); 
//            return false;
//        }
//        }
//        else {
//            System.out.println("Error: El usuario ya existe"); 
//            return false;
//        }     
//    }
    
    
    //Metodo para crear un usuario de forma automatica sin formulario
    
//     public  void createMockUser() {
//         LocalDate fecha = LocalDate.of(2023, 9, 18); 
//         LocalDateTime fechaTime = LocalDateTime.now();
//         Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//         TarjetaDeCredito t1 = new TarjetaDeCredito("Felix",1234_1234_1234_1234L,fecha);
//         Direccion d1 = new Direccion("calleEjemplo",2,28829,"Madrid");
//         ClienteParticular c1 = new ClienteParticular("20120000-F", "Felix", d1,t1,"91-2240234","pass","felix@uah.es",to1);
//         usuarios.put("felix@uah.es", c1);
//    }
     
//     public  void createMockAdminUser() {         
//         Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//         if (!usuarios.containsKey("admin@javacomp.com")) {
//            Usuario a1 = new Administrador("admin","admin",to1 );
//            a1.setAdministrador(true);
//            usuarios.put(a1.getCorreo(), a1);
//         }
//    }
     
//    public Usuario getUser(String correo,String clave){
//       Usuario u1  = usuarios.get(correo);
//       return u1;
//    }
//    
//    public Usuario getUser(String correo){
//       Usuario u1  = usuarios.get(correo);
//       return u1;
//    }
    
//    public boolean deleteUser(String correo){
//       if (usuarios.containsKey(correo)){
//            try {
//                usuarios.remove(correo);
//                return true;
//           }
//            catch (Exception e) {
//                System.out.println("Error: No se ha podido eliminar al usuario: " + e.toString()); 
//                return false;
//            }
//       }
//       else {
//           return false;
//       }
//    }
    
//    public ArrayList<String> getUser(){
//         ArrayList<String> listOfKeys = usuarios.keySet().stream().collect(Collectors.toCollection(ArrayList::new));
//         return listOfKeys;
//    }
    
//    public String TypeUser(String correo,String clave){
//        Usuario u1  = usuarios.get(correo);
//        String clase = usuarios.get(correo).getClass().getSimpleName();
//        return clase;  
//    }
  
}
