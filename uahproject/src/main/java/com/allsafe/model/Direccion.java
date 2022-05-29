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
public class Direccion implements Serializable{
    
    private String calle;
    
    private int numero;
    
    private int cp;
    
    private String ciudad;
   
    /**
     *
     * @param calle
     * @param numero
     * @param cp
     * @param ciudad
     */
    public Direccion(String calle, int numero, int cp, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.ciudad = ciudad;
    }
 
// ********************************************************************************************************************     
    /**
     * Nos devuelve la ciudad atributo de la dirección, que se asociará con un usuario.
     * @return
     * <ul>
     * <li> String Ciudad: Ciudad atributo de la dirección.</li>
     * </ul>
     */
    public String getCiudad() {
        return ciudad;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite etablecer la ciudad  atributo de la dirección, que se asociará con un usuario.
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos devuelve el código postal  atributo de la dirección, que se asociará con un usuario.
     * @return
     * <ul>
     * <li> Int cp: CP atributo de la  dirección.</li>
     * </ul>
     */
    public int getCp() {
        return cp;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite etablecer el código postal  atributo de la dirección, que se asociará con un usuario.
     * @param cp
     */
    public void setCp(int cp) {
        this.cp = cp;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos devuelve el numero  atributo de la dirección, que se asociará con un usuario.
     * @return
     * <ul>
     * <li> Int numero: Numero atributo de la  dirección.</li>
     * </ul>
     */
    public int getNumero() {
        return numero;
    }
// ******************************************************************************************************************** 
    

// ********************************************************************************************************************     
    /**
     * Nos permite etablecer el numero atributo de la dirección, que se asociará con un usuario.
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos devuelve la calle  atributo de la dirección, que se asociará con un usuario.
     * @return
     * <ul>
     * <li> String calle: Calle atributo de la  dirección.</li>
     * </ul>
     */
    public String getCalle() {
        return calle;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite etablecer la calle atributo de la dirección, que se asociará con un usuario.
     * @param calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }
// ******************************************************************************************************************** 
    
// ********************************************************************************************************************     
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", numero=" + numero + ", cp=" + cp + ", ciudad=" + ciudad + '}';
    }
// ********************************************************************************************************************    
    
}
