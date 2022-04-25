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



    public Clientes(String nombre, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, String telefono, String clave, String correo) {
        super(clave, correo);
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.telefono = telefono;
        this.carritoCompra = new CarritoCompra();
    }
    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public TarjetaDeCredito getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    
    
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return super.toString()  + "Clientes{" + "nombre=" + nombre + ", carritoCompra=" + carritoCompra + ", direccion=" + direccion + ", tarjetaDeCredito=" + tarjetaDeCredito + ", telefono=" + telefono + '}';
    }

    
    
}
