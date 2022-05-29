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
     *
     * @param cif
     * @param web
     * @param nombre
     * @param direccion
     * @param tarjetaDeCredito
     * @param telefono
     * @param clave
     * @param correo
     * @param token
     */
    public ClienteEmpresa(String cif, String web, String nombre, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, String telefono, String clave, String correo, Token token) {
        super(nombre, direccion, tarjetaDeCredito, telefono, clave, correo, token);
        this.cif = cif;
        this.web = web;
    }

// ********************************************************************************************************************     
    /**
     * Nos devuelve la web asociada a un cliente de tipo empresa.
     * @return
     * <ul>
     * <li> String web: Web asociada al cliente de tipo Empresa</li>
     * </ul>
     */
    public String getWeb() {
        return web;
    }
// ******************************************************************************************************************** 
    
    
    
// ********************************************************************************************************************     
    /**
     * Nos permite etablecer la web asociada a un cliente de tipo empresa.
     * @param web
     */
    public void setWeb(String web) {
        this.web = web;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos devuelve el Cif asociada a un cliente de tipo empresa.
     * @return
     * <ul>
     * <li> String cif: Cif asociado al cliente de tipo Empresa</li>
     * </ul>
     */
    public String getCif() {
        return cif;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     *
     * Nos permite etablecer el cif asociada a un cliente de tipo empresa.
     * @param cif
     */
    public void setCif(String cif) {
        this.cif = cif;
    }
// ******************************************************************************************************************** 
    
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()  + "ClienteEmpresa{" + "cif=" + cif + ", web=" + web + '}';
    }
    
    

    
}
