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
import static java.time.LocalDate.now;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author felixcentenera
 */
public class UsersServices {

// ********************************************************************************************************************     
    /**
     *
     * @param correo
     * @param clave
     * @return
     */
    public  static boolean checkUser(String correo,String clave) {
       //System.out.println("HOLA SOY USERDATA" + usuarios.get(correo).getClave());
        System.out.println("INFO: Se va a comprobar las credenciales de : " + correo);
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
    // ******************************************************************************************************************** 
    
    
    // ******************************************************************************************************************** 
    // Método para añadir usuarios clientes particulares.
    /**
     * Nos permite añadir un nuevo usuario de tipo clienteParticular al sistema. El usuario se creará y añadirá a
     * la estructura de datos que contiene a todos los usuarios.
     * @param dni
     * @param nombre
     * @param direccionCalle
     * @param direccionCiudad
     * @param direccionNumero
     * @param direccionCP
     * @param tarjetaDeCreditoNumero
     * @param tarjetaDeCreditoTitular
     * @param tarjetaDeCreditoCaducidad
     * @param telefono
     * @param clave
     * @param correo
     * @return
     * <ul>
     * <li> True: Si el usuario se ha añadido correctamente.</li>
     * <li> False: Si el usuario no se ha añadido correctamente.</li>
     * </ul>
     */
    public static boolean addUser(String dni, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
        if (!UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            //System.out.println( dni + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
            UserData.getInstance().getUserHashMap().put(correo, u1);    
            //System.out.println(UserData.getInstance().getUserHashMap().toString());
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            JOptionPane.showMessageDialog(null, "INFO: El usuario no ha podido ser creado, contacte con nosotros","Información para el usuario", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    
        }
        else {
            System.out.println("Error: El usuario ya existe"); 
            JOptionPane.showMessageDialog(null, "INFO: El usuario ya existe","Información para el usuario", JOptionPane.WARNING_MESSAGE);
            return false;
        
        }
    }
    // ******************************************************************************************************************** 
    
    
    // ******************************************************************************************************************** 
    /**
     *
     * Nos permite añadir un nuevo usuario de tipo administrador al sistema. El usuario se creará y añadirá a
     * la estructura de datos que contiene a todos los usuarios.
     * @param clave
     * @param correo
     * @return
     * <ul>
     * <li> True: Si el usuario se ha añadido correctamente.</li>
     * <li> False: Si el usuario no se ha añadido correctamente.</li>
     * </ul>
     */
    public static boolean addAdmin(String clave, String correo){
        if (!UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            //System.out.println( clave + correo);
            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
            Usuario a1 = new Administrador(clave, correo, to1);
            UserData.getInstance().getUserHashMap().put(correo, a1);    
            //System.out.println(UserData.getInstance().getUserHashMap().toString());
            JOptionPane.showMessageDialog(null, "Se ha añadido un nuevo administrador, welcome to Allsafe","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            return false;
        }
    
        }
        else {
            System.out.println("Error: El usuario ya existe"); 
            JOptionPane.showMessageDialog(null, "El usuario ya existe","Información para el usuario", JOptionPane.WARNING_MESSAGE);
            return false;
        
        }
    }
    // ******************************************************************************************************************** 
    
    
    
    // ******************************************************************************************************************** 
     // Método para modificar usuarios clientes particulares.
    /**
     * Nos permite modificar la informacón de usuario de tipo cliente particular a partir
     * de la información prevista como método.
     * @param dni
     * @param nombre
     * @param direccionCalle
     * @param direccionCiudad
     * @param direccionNumero
     * @param direccionCP
     * @param tarjetaDeCreditoNumero
     * @param tarjetaDeCreditoTitular
     * @param tarjetaDeCreditoCaducidad
     * @param telefono
     * @param clave
     * @param correo
     * @return
     * <ul>
     * <li> True: Si el usuario se ha modificado correctamente.</li>
     * <li> False: Si el usuario no se ha modificado correctamente.</li>
     * </ul>
     */
    public static boolean setUser(String dni, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
        if (UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            //System.out.println( dni + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
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
            
            //System.out.println(UserData.getInstance().getUserHashMap().toString());
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
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Nos permite modificar la informacón de usuario de tipo cliente Empresa a partir
     * de la información prevista como método.
     * @param cif
     * @param web
     * @param nombre
     * @param direccionCalle
     * @param direccionCiudad
     * @param direccionNumero
     * @param direccionCP
     * @param tarjetaDeCreditoNumero
     * @param tarjetaDeCreditoTitular
     * @param tarjetaDeCreditoCaducidad
     * @param telefono
     * @param clave
     * @param correo
     * @return
     * <ul>
     * <li> True: Si el usuario se ha modificado correctamente.</li>
     * <li> False: Si el usuario no se ha modificado correctamente.</li>
     * </ul>
     */
    public static boolean setUser(String cif,String web, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
        if (UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            //System.out.println( cif + nombre + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
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
            
            //System.out.println(UserData.getInstance().getUserHashMap().toString());
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
    // ******************************************************************************************************************** 
    
    
    
    // ******************************************************************************************************************** 
    /**
     * Nos permite modificar la clave de un usuario.
     * @param clave
     * @param correo
     * @return
     * <ul>
     * <li> True: Si la clave  del usuario se ha modificdo correctamente.</li>
     * <li> False: Si la clave  del usuario no se ha modificdo correctamente..</li>
     * </ul>
     */
    public static boolean setUser(String clave, String correo){
        if (UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            //System.out.println( clave + correo);
//            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
//            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
//            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//            Usuario u1 = new ClienteParticular(dni, nombre, d1,t1,telefono,clave,correo,to1);
//            usuarios.put(correo, u1);    
            UserData.getInstance().getUserHashMap().get(correo).setClave(clave);
            //System.out.println(UserData.getInstance().getUserHashMap().toString());
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
    // ******************************************************************************************************************** 
    
    
    
    // ******************************************************************************************************************** 
    // Método para añadir usuarios clientes empresa. String cif, String web
    /**
     * Nos permite añadir un nuevo usuario de tipo clienteParticular al sistema. El usuario se creará y añadirá a
     * la estructura de datos que contiene a todos los usuarios.
     * @param cif
     * @param web
     * @param nombre
     * @param direccionCalle
     * @param direccionCiudad
     * @param direccionNumero
     * @param direccionCP
     * @param tarjetaDeCreditoNumero
     * @param tarjetaDeCreditoTitular
     * @param tarjetaDeCreditoCaducidad
     * @param telefono
     * @param clave
     * @param correo
     * @return
     * <ul>
     * <li> True: Si el usuario se ha añadido correctamente.</li>
     * <li> False: Si el usuario no se ha añadido correctamente.</li>
     * </ul>
     */
    public static boolean addUser(String cif, String web, String nombre, String direccionCalle,String direccionCiudad,int direccionNumero,int direccionCP,long tarjetaDeCreditoNumero,String tarjetaDeCreditoTitular,LocalDate tarjetaDeCreditoCaducidad ,String telefono, String clave, String correo){
        
        if (!UserData.getInstance().getUserHashMap().containsKey(correo)){
        try{
            //System.out.println( cif + nombre + web + direccionCalle + direccionCiudad + direccionNumero + direccionCP + tarjetaDeCreditoNumero + tarjetaDeCreditoTitular + tarjetaDeCreditoCaducidad + telefono + clave + correo);
            Direccion d1 =  new Direccion(direccionCalle,direccionNumero,direccionCP,direccionCiudad);
            TarjetaDeCredito t1 = new TarjetaDeCredito(tarjetaDeCreditoTitular,tarjetaDeCreditoNumero,tarjetaDeCreditoCaducidad);
            Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
            Usuario u1 = new ClienteEmpresa(cif, web, nombre, d1,t1,telefono,clave,correo,to1);
            UserData.getInstance().getUserHashMap().put(correo, u1);    
            //System.out.println(UserData.getInstance().getUserHashMap().toString());
            return true;
        }catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            JOptionPane.showMessageDialog(null, "INFO: El usuario no ha podido ser creado, contacte con nosotros","Información para el usuario", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        }
        else {
            System.out.println("Error: El usuario ya existe"); 
            JOptionPane.showMessageDialog(null, "INFO: El usuario ya existe","Información para el usuario", JOptionPane.WARNING_MESSAGE);
            return false;
        }     
    }
// ********************************************************************************************************************     
    
    
 //Metodo para crear un usuario de forma automatica sin formulario
//     public  static void createMockUser() {
//         LocalDate fecha = LocalDate.of(2020, 9, 18); 
//         LocalDateTime fechaTime = LocalDateTime.now();
//         Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//         TarjetaDeCredito t1 = new TarjetaDeCredito("Felix",1234_1234_1234_1234L,fecha);
//         Direccion d1 = new Direccion("calleEjemplo",2,28829,"Madrid");
//         ClienteParticular c1 = new ClienteParticular("20120000-F", "Felix", d1,t1,"91-2240234","pass","felix@uah.es",to1);
//         UserData.getInstance().getUserHashMap().put("felix@uah.es", c1);
//    }

    
// ********************************************************************************************************************     
    /**
     * Nos permite crear el usuario administrador en la plataforma.
     */
     public static void createMockAdminUser() {    
         
         if (!existsUser("admin@javacomp.com")) {
             Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
             if (!UserData.getInstance().getUserHashMap().containsKey("admin@javacomp.com")) {
                System.out.println("INFO: El usuario admin no exite, vamos a crearlo, usuario: admin@javacomp.com, pass: admin. Recuerde cambiar la password "); 
                Usuario a1 = new Administrador("admin","admin@javacomp.com",to1 );
                a1.setAdministrador(true);
                UserData.getInstance().getUserHashMap().put(a1.getCorreo(), a1);
                UsersServices.saveUserData();
                //JOptionPane.showMessageDialog(null, "Se ha creado el usuario administrador: admin@javacomp.com, pass: admin. Recuerde cambiar la password","Información para el usuario", JOptionPane.INFORMATION_MESSAGE);
             }
         }
         else {
             System.out.println("INFO: El usuario admin ya exite, no lo creamos.");
         }
     
     }
// ******************************************************************************************************************** 
     
// ********************************************************************************************************************      
    /**
     * Nos permite obtener un usuario mediante la clave correo y el valor clave.
     * @param correo
     * @param clave
     * @return
     * <ul>
     * <li> Usuario u1</li>
     * </ul>
     */
    public static Usuario getUser(String correo,String clave){
       Usuario u1  = UserData.getInstance().getUserHashMap().get(correo);
       return u1;
    }
// ******************************************************************************************************************** 



// ********************************************************************************************************************     
    /**
     * Nos permite obtener un usuario mediante el la clave correo.
     * @param correo
     * @return
     * <ul>
     * <li> Usuario u1</li>
     * </ul>
     */
    public static Usuario getUser(String correo){
       Usuario u1  = UserData.getInstance().getUserHashMap().get(correo);
       return u1;
    }
 // ********************************************************************************************************************    
 
    
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite preguntar si existe un usario en la estructura de datos UserHashMap
     * @param correo
     * @return
     * <ul>
     * <li> True: Si el usuario exite.</li>
     * <li> False: Si el usuario no exite.</li>
     * </ul>
     */
    public static boolean existsUser(String correo){
       if (UserData.getInstance().getUserHashMap().containsKey(correo)) {
           System.out.println("INFO: EL usuario" + correo + " sí existe");
        return true;
       }
       else {
           System.out.println("INFO: EL usuario " + correo + " no existe");
           return false;
       }
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite borrar un usuario de la estrutura de datos UserHashMap mediante 
     * el paso de un String correo que se utilizará como clave para la busqueda y
     * eliminación dicho usuario.
     * @param correo
     * @return
     * <ul>
     * <li> True: Si el usuario se ha eliminad correctamente.</li>
     * <li> False: Si el usuario no se ha eliminad correctamente.</li>
     * </ul>
     */
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
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Nos permite recuperar un ArrayList String con todas las claves "keys" de los 
     * usuarios de las estructura de datos 
     * UserHashMap.
     * @return
     * <ul>
     * <li> ArrayList String claves usuarios</li>
     * </ul>
     */
    public static ArrayList<String> getUser(){
         ArrayList<String> listOfKeys = UserData.getInstance().getUserHashMap().keySet().stream().collect(Collectors.toCollection(ArrayList::new));
         return listOfKeys;
    }
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * NOs permite obtener un ArrayList de productos, con todos los productos 
     * de un usuario proporcionado.
     * @param u
     * @return
     * <ul>
     * <li> ArrayList Productos productos de un  usuario</li>
     * </ul>
     */
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
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Nos permite borrar un articulo del carrito de un usuario proporcionado.
     * @param u
     * @param producto
     * @return
     * <ul>
     * <li> True: Si el producto se ha borrado correctamente del carrito del usuario proporcionado.</li>
     * <li> False: Si el producto no se ha borrado correctamente del carrito del usuario proporcionado.</li>
     * </ul>
     */
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
    // ******************************************************************************************************************** 
    
    
    // ******************************************************************************************************************** 
    /**
     * Permite quitar todos los productos del carrito de un usuario proporcionado.
     * @param u
     * @return
     * <ul>
     * <li> True: Si se han eliminado correctamente los productos  del carrito del usuario proporcionado.</li>
     * <li> False: Si no se han eliminado correctamente los productos  del carrito del usuario proporcionado.</li>
     * </ul>
     */
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
    // ******************************************************************************************************************** 
    
    
    
// ********************************************************************************************************************     
//    public static ArrayList<String>  getUser(){
//         return UserData.getInstance().getUserHashMap().keySet().stream().collect(Collectors.toCollection(ArrayList::new));
//    }
// ******************************************************************************************************************** 
    
    
    
 // ********************************************************************************************************************    
    /**
     * Nos permite conocer el tipo de usuario metiante el paso de la clave (key) correo
     * el valor clave de un usuario.
     * @param correo
     * @param clave
     * @return
     * <ul>
     * <li> clase del usuario solicitado.</li>
     * </ul>
     */
    
    public static String TypeUser(String correo,String clave){
        Usuario u1  = UserData.getInstance().getUserHashMap().get(correo);
        String clase = UserData.getInstance().getUserHashMap().get(correo).getClass().getSimpleName();
        return clase;  
    }
 // ******************************************************************************************************************** 
    
    
    
 // ********************************************************************************************************************   
    /**
     * SERIALIZACION DE LOS ARCHIVOS
     */ 
    public static void saveUserData() {
    //Vamos a Serializar el objeto SalesData en memoria no Volatil.
    /**
     * Nos permite exportar toda la información de la estuctura de datos UserHashMap
     * a un fichero local para su futura recuperación.
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
    // ******************************************************************************************************************** 
    
    // ******************************************************************************************************************** 
    /**
     * Nos permite recuperar de un fichero local toda la información para de la estuctura de datos UserHashMap
     */
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
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    /**
     * Nos pemite verificar que el DNI proporcionado tiene la composición apropiada
     * @param DNI
     * @return
     * <ul>
     * <li> True: Si el DNI proporcionado es correcto. </li>
     * <li> False: Si el DNI proporcionado no es correcto.</li>
     * </ul>
     */
    public static boolean checkDNI(String DNI){
        try{
            if (DNI.charAt(DNI.length() -1 ) == letterDNI(DNI) ){
                System.out.println("INFO: El DNI es correcto");
                return true;
            }    
            else {
                System.out.println("INFO: El DNI no es correcto");
                return false;
            }
        }
      
        catch (Exception ex) {
            System.out.println("Error: " + ex.toString()); 
            return false;
        }   
    }
// ******************************************************************************************************************** 


// ********************************************************************************************************************     
    private static char letterDNI(String DNI){
        int dniNumber = Integer.parseInt(DNI.substring(0, DNI.length()-1 )  );
        dniNumber = dniNumber % 23;
        char lettersDNI[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        return lettersDNI[dniNumber];
    }
// ******************************************************************************************************************** 

// ********************************************************************************************************************     
    /**
     * Nos permite saber si la tarjeta de crédito, de un usuario proporcionado,
     * ha caducado o sigue vigente.
     * @param u
     * @return
     * <ul>
     * <li> True: Si la tarjeta de crédito no ha caducada. </li>
     * <li> False: Si la tarjeta de crédito  ha caducada.</li>
     * </ul>
     */
    public static boolean checkDateCreditCard(Usuario u){
        if ((UsersServices.TypeUser(u.getCorreo(),u.getClave())).equals("ClienteParticular")) {
            ClienteParticular c1 = (ClienteParticular) u;
            try{
                //c1.getCarritoCompra().getProductos().clear();
                //c1.getTarjetaDeCredito().getFechaCaducidad();
                // fecha.isAfter(LocalDate.now()
                if (c1.getTarjetaDeCredito().getFechaCaducidad().isAfter(LocalDate.now()) ) {
                    System.out.println("INFO: La tarjeta de credito esta actualizada.");
                    return true;
                }
                else {
                    System.out.println("INFO: La tarjeta de credito esta caducada.");
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
                if (c1.getTarjetaDeCredito().getFechaCaducidad().isAfter(LocalDate.now()) ) {
                    System.out.println("INFO: La tarjeta de credito esta actualizada.");
                    return true;
                }
                else {
                    System.out.println("INFO: La tarjeta de credito esta caducada.");
                    return false;
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.toString());  
                return false;
            }
        }
    }
// ********************************************************************************************************************     
    
    
    
}
