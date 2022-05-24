/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

/**
 *
 * @author felixcentenera
 */
public class ClienteEmpresa extends Clientes{
    
    private String cif;
    
    private String web;

    /**
     * @param cif
     * @param web
     * @param nombre
     * @param direccion
     * @param tarjetaDeCredito
     * @param telefono
     * @param clave
     * @param correo
     * @param token
     * 
     * Constructor de Cliente empresa.
     */

    public ClienteEmpresa(String cif, String web, String nombre, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, String telefono, String clave, String correo, Token token) {
        super(nombre, direccion, tarjetaDeCredito, telefono, clave, correo, token);
        this.cif = cif;
        this.web = web;
    }
    
   /**
     * @return web
     * Getter*/
    public String getWeb() {
        return web;
    }
    /**
     * @param web 
     * Setter*/
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * @return cif 
     * Getter*/
    public String getCif() {
        return cif;
    }
    /**
     * @param cif 
     * Setter*/
    public void setCif(String cif) {
        this.cif = cif;
    }
    /**
     * @return 
     * retorna todo los atributos por pantalla*/
    @Override
    public String toString() {
        return super.toString()  + "ClienteEmpresa{" + "cif=" + cif + ", web=" + web + '}';
    }
    
    

    
}
