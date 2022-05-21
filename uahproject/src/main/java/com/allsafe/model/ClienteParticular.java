/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import java.io.Serializable;

/**
 *
 * @author felixcentenera
 */
public class ClienteParticular extends Clientes implements Serializable{
    
    private String dni;

    public ClienteParticular(String dni, String nombre, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, String telefono, String clave, String correo, Token token) {
        super(nombre, direccion, tarjetaDeCredito, telefono, clave, correo, token);
        this.dni = dni;
    }

    public String getDni() {
        return dni;   
    }

    public void setDni(String dni) {
        this.dni = dni;  
    }

    @Override
    public String toString() {
        return super.toString()  +"ClienteParticular{" + "dni=" + dni + '}';
    }

    
    
}
