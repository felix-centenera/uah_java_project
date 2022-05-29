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
     *
     * @param nombre
     * @param direccion
     * @param tarjetaDeCredito
     * @param telefono
     * @param clave
     * @param correo
     * @param token
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
     * Nos devuelve el telefono asociado a un cliente.
     * @return
     * <ul>
     * <li> String telefono: Telefono asociado al cliente.</li>
     * </ul>
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Nos permite etablecer el telefono asociado a un cliente.
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Nos devuelve la tarjetaDeCredito asociado a un cliente.
     * @return
     * <ul>
     * <li> String TarjetaDeCredito: TarjetaDeCredito asociado al cliente.</li>
     * </ul>
     */
    public TarjetaDeCredito getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    /**
     * Nos permite etablecer la tarjetaDeCredito asociado a un cliente.
     * @param tarjetaDeCredito
     */
    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    /**
     * Nos devuelve la Direccion asociado a un cliente.
     * @return
     * <ul>
     * <li> String direccion: Direccion asociado al cliente.</li>
     * </ul>
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Nos permite etablecer la direccion asociada a un cliente.
     * @param direccion
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Nos devuelve el CarritoCompra asociado a un cliente.
     * @return
     * <ul>
     * <li> CarritoCompra: CarritoCompra asociado al cliente.</li>
     * </ul>
     */
    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }
    
    /**
     * Nos devuelve el nombre asociado a un cliente.
     * @return
     * <ul>
     * <li> String nombre: Nombre asociado al cliente.</li>
     * </ul>
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Nos permite etablecer eñ nombre asociada a un cliente.
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()  + "Clientes{" + "nombre=" + nombre + ", carritoCompra=" + carritoCompra + ", direccion=" + direccion + ", tarjetaDeCredito=" + tarjetaDeCredito + ", telefono=" + telefono + '}';
    }

    
    
}
