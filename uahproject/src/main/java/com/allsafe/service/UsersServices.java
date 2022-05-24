/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.UserData;
import com.allsafe.model.Administrador;
import com.allsafe.model.ClienteEmpresa;
import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Direccion;
import com.allsafe.model.Producto;
import com.allsafe.model.TarjetaDeCredito;
import com.allsafe.model.Token;
import com.allsafe.model.Usuario;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author felixcentenera
 */
public class UsersServices {
    
    
    
    public  static boolean checkUser(String correo,String clave) {
       //System.out.println("HOLA SOY USERDATA" + usuarios.get(correo).getClave());
        System.out.println(correo);
        //System.out.println(clave);
       if (  UserData.getInstance().getUserHashMap().containsKey(correo)   ){
           System.out.println("INFO: He encontrado el correo entre los datos ");
           if (UserData.getInstance().getUserHashMap().get(correo).getClave().equals(clave)   ){
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
    
    
    // Método para añadir usuarios clientes particulares.
    public static boolean addUser(String dni, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
        if (!UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            System.out.println( dni + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
            UserData.getInstance().getUserHashMap().put(correo, u1);    
            System.out.println(UserData.getInstance().getUserHashMap().toString());
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            return false;
        }
    
        }
        else {
            System.out.println("Error: El usuario ya existe"); 
            return false;
        
        }
    }
    
    
    public static boolean addAdmin(String clave, String correo){
        if (!UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            System.out.println( clave + correo);
            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
            Usuario a1 = new Administrador(clave, correo, to1);
            UserData.getInstance().getUserHashMap().put(correo, a1);    
            System.out.println(UserData.getInstance().getUserHashMap().toString());
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            return false;
        }
    
        }
        else {
            System.out.println("Error: El usuario ya existe"); 
            return false;
        
        }
    }
    
    
     // Método para añadir usuarios clientes particulares.
    public static boolean setUser(String dni, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
        if (UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            System.out.println( dni + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
//            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
//            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
//            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
//            usuarios.put(correo, u1);    
            
            ClienteParticular c1 = (ClienteParticular) UserData.getInstance().getUserHashMap().get(correo);
            c1.setDni(dni);
            c1.setNombre(nombre);
            c1.getDireccion().setCalle(direccionCalle);
            c1.getDireccion().setCiudad(direccionCiudad);
            c1.getDireccion().setNumero(direccionNumero);
            c1.getDireccion().setCp(direccionCP);
            c1.getTarjetaDeCredito().setNumeronumeroTarjetaCredito(tarjetaDeCreditoNumero);
            c1.getTarjetaDeCredito().setNombreTitular(tarjetaDeCreditoTitular);
            c1.getTarjetaDeCredito().setFechaCaducidad(tarjetaDeCreditoCaducidad);
            c1.setTelefono(telefono);
            c1.setClave(clave);
            
            System.out.println(UserData.getInstance().getUserHashMap().toString());
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            return false;
        }
    
        }
        else {
            System.out.println("Error: El usuario no  existe"); 
            return false;
        
        }
    }
    
    
    public static boolean setUser(String cif,String web, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
        if (UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            System.out.println( cif + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
//            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
//            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
//            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
//            usuarios.put(correo, u1);    
            
            ClienteEmpresa c1 = (ClienteEmpresa) UserData.getInstance().getUserHashMap().get(correo);
            c1.setCif(cif);
            c1.setWeb(web);
            c1.setNombre(nombre);
            c1.getDireccion().setCalle(direccionCalle);
            c1.getDireccion().setCiudad(direccionCiudad);
            c1.getDireccion().setNumero(direccionNumero);
            c1.getDireccion().setCp(direccionCP);
            c1.getTarjetaDeCredito().setNumeronumeroTarjetaCredito(tarjetaDeCreditoNumero);
            c1.getTarjetaDeCredito().setNombreTitular(tarjetaDeCreditoTitular);
            c1.getTarjetaDeCredito().setFechaCaducidad(tarjetaDeCreditoCaducidad);
            c1.setTelefono(telefono);
            c1.setClave(clave);
            
            System.out.println(UserData.getInstance().getUserHashMap().toString());
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            return false;
        }
    
        }
        else {
            System.out.println("Error: El usuario no  existe"); 
            return false;
        
        }
    }
    
    public static boolean setUser(String clave, String correo){
        if (UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            System.out.println( clave + correo);
//            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
//            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
//            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
//            usuarios.put(correo, u1);    
            UserData.getInstance().getUserHashMap().get(correo).setClave(clave);
            System.out.println(UserData.getInstance().getUserHashMap().toString());
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            return false;
        }
    
        }
        else {
            System.out.println("Error: El usuario no  existe"); 
            return false;
        
        }
    }
    
    // Método para añadir usuarios clientes empresa. String cif, String web
    public static boolean addUser(String cif, String web, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
        
        if (!UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            System.out.println( cif + nombre + web + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
            Usuario u1 = new ClienteEmpresa(cif, web, nombre, d1,t1,telefono,clave,correo,to1);
            UserData.getInstance().getUserHashMap().put(correo, u1);    
            System.out.println(UserData.getInstance().getUserHashMap().toString());
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            return false;
        }
        }
        else {
            System.out.println("Error: El usuario ya existe"); 
            return false;
        }     
    }
    
    
     //Metodo para crear un usuario de forma automatica sin formulario
    
     public  static void createMockUser() {
         LocalDate fecha = LocalDate.of(2023, 9, 18); 
         LocalDateTime fechaTime = LocalDateTime.now();
         Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
         TarjetaDeCredito t1 = new TarjetaDeCredito("Felix",1234_1234_1234_1234L,fecha);
         Direccion d1 = new Direccion("calleEjemplo",2,28829,"Madrid");
         ClienteParticular c1 = new ClienteParticular("20120000-F", "Felix", d1,t1,"91-2240234","pass","felix@uah.es",to1);
         UserData.getInstance().getUserHashMap().put("felix@uah.es", c1);
    }
     
     public static void createMockAdminUser() {         
         Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
         if (!UserData.getInstance().getUserHashMap().containsKey("admin@javacomp.com")) {
            Usuario a1 = new Administrador("admin","admin",to1 );
            a1.setAdministrador(true);
            UserData.getInstance().getUserHashMap().put(a1.getCorreo(), a1);
         }
    }
     
    public static Usuario getUser(String correo,String clave){
       Usuario u1  = UserData.getInstance().getUserHashMap().get(correo);
       return u1;
    }
    
    public static Usuario getUser(String correo){
       Usuario u1  = UserData.getInstance().getUserHashMap().get(correo);
       return u1;
    }
    
    public static boolean deleteUser(String correo){
       if (UserData.getInstance().getUserHashMap().containsKey(correo)){
            try {
                UserData.getInstance().getUserHashMap().remove(correo);
                return true;
           }
            catch (Exception e) {
                System.out.println("Error: No se ha podido eliminar al usuario: " + e.toString()); 
                return false;
            }
       }
       else {
           return false;
       }
    }
    
    public static ArrayList<String> getUser(){
         ArrayList<String> listOfKeys = UserData.getInstance().getUserHashMap().keySet().stream().collect(Collectors.toCollection(ArrayList::new));
         return listOfKeys;
    }
    
    public static ArrayList<Producto> getObjectShoppingCart(Usuario u){
        if ((UsersServices.TypeUser(u.getCorreo(),u.getClave())).equals("ClienteParticular")) {
            ClienteParticular c1 = (ClienteParticular) u;
            return (c1.getCarritoCompra().getProductos());
        }
        else{
            ClienteEmpresa c1 = (ClienteEmpresa) u;
            return (c1.getCarritoCompra().getProductos());
        }
}
    
    
    public static boolean deleteObjectShoppingCart(Usuario u, Producto producto){
        if ((UsersServices.TypeUser(u.getCorreo(),u.getClave())).equals("ClienteParticular")) {
            ClienteParticular c1 = (ClienteParticular) u;
            try{
                if (c1.getCarritoCompra().deleteProducto(producto)){
                return true;
                
                }
                else {
                    return false;
                }
            
            }
            catch (Exception e) {
                System.out.println("Error: " + e.toString());  
                return false;
              }
        }
        else{
            ClienteEmpresa c1 = (ClienteEmpresa) u;
            try{
                if (c1.getCarritoCompra().deleteProducto(producto)){
                return true;
                
                }
                else {
                    return false;
                }
            
            }
            catch (Exception e) {
                System.out.println("Error: " + e.toString());  
                return false;
              }
        }
    }
    
    
    public static boolean cleanShoppingCart(Usuario u){
        if ((UsersServices.TypeUser(u.getCorreo(),u.getClave())).equals("ClienteParticular")) {
            ClienteParticular c1 = (ClienteParticular) u;
            try{
                c1.getCarritoCompra().getProductos().clear();
                return true;
            }
            catch (Exception e) {
                System.out.println("Error: " + e.toString());  
                return false;
              }
        }
        else{
            ClienteEmpresa c1 = (ClienteEmpresa) u;
            try{
                c1.getCarritoCompra().getProductos().clear();
                return true;
            }
            catch (Exception e) {
                System.out.println("Error: " + e.toString());  
                return false;
            }
        }
    }
    
    
//    public static ArrayList<String>  getUser(){
//         return UserData.getInstance().getUserHashMap().keySet().stream().collect(Collectors.toCollection(ArrayList::new));
//    }
    
    public static String TypeUser(String correo,String clave){
        Usuario u1  = UserData.getInstance().getUserHashMap().get(correo);
        String clase = UserData.getInstance().getUserHashMap().get(correo).getClass().getSimpleName();
        return clase;  
    }
    
    
    /**
     * SERIALIZACION DE LOS ARCHIVOS
     */
    
    public static void saveUserData() {
    //Vamos a Serializar el objeto SalesData en memoria no Volatil.
    /**
     * Se nos obliga a meter una exception
     */
    //UserData userDat = UserData.getInstance();
    try {
        FileOutputStream myFileOutStream = new  FileOutputStream ("localDataMock/UserDataLocal.dat");
        ObjectOutputStream myObjectOutStream = new ObjectOutputStream(myFileOutStream);
        myObjectOutStream.writeObject(UserData.getInstance().getUserHashMap());
        
        myObjectOutStream.close();
        myFileOutStream.close();
        System.out.println("INFO: Se guardan los usuarios" );
    }
    catch (IOException e){
                    System.out.println("Error:  No ha podido realizarse el guardado: " + e.toString()); 
                    //jPanelUsersFound.setVisible(false);
            }
    } 
    
    
    public static void initUserDataMock() {
        try {      
            FileInputStream fileInput = new FileInputStream("localDataMock/UserDataLocal.dat");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);     
            try {
                HashMap<String, Usuario> usuarios = new HashMap<>();
                usuarios = (HashMap)objectInput.readObject();
                UserData.getInstance().getUserHashMap().putAll(usuarios);
                System.out.println("INFO : Se realiza la carga de usuarios");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsersServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            objectInput.close();
            fileInput.close();    
        }
        catch (IOException e){
                    System.out.println("Error:  No ha podido realizarse la recarga de usuarios: " + e.toString()); 
            }
}
    
    
    
    
}
