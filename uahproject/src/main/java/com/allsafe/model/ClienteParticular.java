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
     * @param dni
     * @param nombre
     * @param direccion
     * @param tarjetaDeCredito
     * @param telefono
     * @param clave
     * @param correo
     * @param token
     * Constructor de la clase Cliente Particular
     */
    public ClienteParticular(String dni, String nombre, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, String telefono, String clave, String correo, Token token) {
        super(nombre, direccion, tarjetaDeCredito, telefono, clave, correo, token);
        this.dni = dni;
    }
    /**
     * @return dni
     * Getter
     */
    public String getDni() {
        return dni;   
    }
    /**
     * @param dni 
     * Setter
     */
    public void setDni(String dni) {
        this.dni = dni;  
    }
    /**
     * @return 
     * Retorna los atributos del objeto ClienteParticular
     */
    @Override
    public String toString() {
        return super.toString()  +"ClienteParticular{" + "dni=" + dni + '}';
    }

    
    
}
