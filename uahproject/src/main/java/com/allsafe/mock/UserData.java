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

    
// ******************************************************************************************************************** 
    /**
     *
     * @return
     * <ul>
     * <li> UserData  HashMap: Un HashMap cuya clave es el correo del usuario y el usuarip como valor</li>
     * </ul>
     */
    public HashMap<String, Usuario> getUserHashMap(){
       return usuarios;
    }
  // ******************************************************************************************************************** 
    
    
    
 // ********************************************************************************************************************    
    //Evitamos la instanciacón directa. Constructor vacío.
    private UserData(){}
 // ******************************************************************************************************************** 
    
    
 // ********************************************************************************************************************    
    /**
     *  Con este método obligamos a que cualquier servicio que requiera la intancia UserData, utilice únicamente una instancia que es común para todos.
     * @return
     *  <ul>
     *  <li> Instancia de la clase UserData: En caso de no existir, el método intancia la clase y se devuelve la misma generada.</li>
     *  </ul>
     */
    public static UserData getInstance(){
        if (instance ==null) {
            instance = new UserData();
        }
        return instance;
    }
// ********************************************************************************************************************     
     
  
}
