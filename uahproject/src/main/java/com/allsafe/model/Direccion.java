/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

/**
 *
 * @author felixcentenera
 */
public class Direccion {
    
    private String calle;
    
    private int numero;
    
    private int cp;
    
    private String ciudad;
   /**
     * @param calle
     * @param numero
     * @param cp
     * @param ciudad*/

    public Direccion(String calle, int numero, int cp, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.ciudad = ciudad;
    }
    
    
    /**
     * @return  
     * Getter*/
    public String getCiudad() {
        return ciudad;
    }
    /**
     * @param ciudad 
     * Setter*/
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return 
     * Getter*/
    public int getCp() {
        return cp;
    }
    /**
     * @param cp 
     * Setter*/
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * @return 
     * Getter*/
    public int getNumero() {
        return numero;
    }
    /**
     * @param numero 
     * Setter*/
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return 
     * Getter*/
    public String getCalle() {
        return calle;
    }
    /**
     * @param calle 
     * Setter */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    /**
     * @return 
     * Retorna el valor de cada uno de los atributos.
     */
    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", numero=" + numero + ", cp=" + cp + ", ciudad=" + ciudad + '}';
    }
    
    

    
}
