/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

/**
 *
 * @author felixcentenera
 */
public class ClienteParticular extends Clientes{
    
    private String dni;

    /**
     *
     * @param dni
     * @param nombre
     * @param direccion
     * @param tarjetaDeCredito
     * @param telefono
     * @param clave
     * @param correo
     * @param token
     */
    public ClienteParticular(String dni, String nombre, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, String telefono, String clave, String correo, Token token) {
        super(nombre, direccion, tarjetaDeCredito, telefono, clave, correo, token);
        this.dni = dni;
    }

    
// ********************************************************************************************************************     
    /**
     * Nos devuelve el dni asociado a un cliente de tipo particular.
     * @return
     * <ul>
     * <li> String DNI: DNI asociado al cliente de tipo particular.</li>
     * </ul>
     */
    public String getDni() {
        return dni;   
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite etablecer el dni asociado a un cliente de tipo particular.
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;  
    }
// ******************************************************************************************************************** 
    

// ********************************************************************************************************************     
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()  +"ClienteParticular{" + "dni=" + dni + '}';
    }
// ******************************************************************************************************************** 
       
}
