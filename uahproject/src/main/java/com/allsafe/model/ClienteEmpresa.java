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

    public ClienteEmpresa(String cif, String web, String nombre, CarritoCompra carritoCompra, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, String telefono, String clave, String correo, Token token) {
        super(nombre, carritoCompra, direccion, tarjetaDeCredito, telefono, clave, correo, token);
        this.cif = cif;
        this.web = web;
    }
    
    
    

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }


    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Override
    public String toString() {
        return super.toString()  + "ClienteEmpresa{" + "cif=" + cif + ", web=" + web + '}';
    }
    
    

    
}