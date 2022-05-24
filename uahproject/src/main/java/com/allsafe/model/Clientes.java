/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

/**
 *
 * @author felixcentenera
 */
public abstract class Clientes extends Usuario{
    
    private String nombre;
    
    private CarritoCompra carritoCompra;
    
    private Direccion direccion;

    private TarjetaDeCredito tarjetaDeCredito;
    
    private String telefono;

    /**
     * @param nombre
     * @param direccion
     * @param tarjetaDeCredito
     * @param telefono
     * @param clave
     * @param correo
     * @param token
     * Constructor de la Clase Clientes
     */
    public Clientes(String nombre, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, String telefono, String clave, String correo, Token token) {
        super(clave, correo, token);
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.telefono = telefono;
        this.carritoCompra = new CarritoCompra();
    }

    /**
     * @return telefono
     * Getter*/
    public String getTelefono() {
        return telefono;
    }
    /**
     * @param telefono
     * Setter
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return tarjetaDeCredito
     * Getter*/
    public TarjetaDeCredito getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }
    /**
     * @param tarjetaDeCredito 
     * Setter*/
    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }
    /**
     * @return 
     * Getter*/
    public Direccion getDireccion() {
        return direccion;
    }
    /**
     * @param direccion 
     * Setter*/
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    /**
     * @return 
     * Getter*/
    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }
    /**
     * @return 
     * Getter*/
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre 
     * Setter*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return retorna String de Cada los atributos de Clientes*/
    @Override
    public String toString() {
        return super.toString()  + "Clientes{" + "nombre=" + nombre + ", carritoCompra=" + carritoCompra + ", direccion=" + direccion + ", tarjetaDeCredito=" + tarjetaDeCredito + ", telefono=" + telefono + '}';
    }

    
    
}
