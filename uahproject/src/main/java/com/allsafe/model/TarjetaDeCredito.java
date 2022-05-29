/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author felixcentenera
 */
public class TarjetaDeCredito implements Serializable{
    
    private String nombreTitular;
    private long numeroTarjetaCredito;
    private LocalDate fechaCaducidad;

    /**
     *
     * @param nombreTitular
     * @param numeroTarjetaCredito
     * @param fechaCaducidad
     */
    public TarjetaDeCredito(String nombreTitular, long numeroTarjetaCredito, LocalDate fechaCaducidad) {
        this.nombreTitular = nombreTitular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.fechaCaducidad = fechaCaducidad;
    }
    
    /**
     * Nos devuelve el nombreTitular  atributo de la Tarjeta de credito, que se asociará con un usuario.
     * @return
     * <ul>
     * <li> String nombreTitular: nombreTitular atributo de la  TarjetaDeCredito.</li>
     * </ul>
     */
    public String getNombreTitular() {
        return nombreTitular;
    }

    /**
     * Nos permite etablecer el nombreTitular atributo de la TarjetaDeCredito, que se asociará con un usuario.
     * @param nombreTitular
     */
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    
    /**
     * Nos devuelve el numeroTarjetaCredito  atributo de la Tarjeta de credito, que se asociará con un usuario.
     * @return
     * <ul>
     * <li> long numeroTarjetaCredito: numeroTarjetaCredito atributo de la  TarjetaDeCredito.</li>
     * </ul>
     */
    public long getnumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    /**
     * Nos permite etablecer el numeroTarjetaCredito atributo de la TarjetaDeCredito, que se asociará con un usuario.
     * @param numeroTarjetaCredito
     */
    public void setNumeronumeroTarjetaCredito(long numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    /**
     * Nos devuelve la fechaCaducidad  atributo de la Tarjeta de credito, que se asociará con un usuario.
     * @return
     * <ul>
     * <li> LocalDate fechaCaducidad: fechaCaducidad atributo de la  TarjetaDeCredito.</li>
     * </ul>
     */
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Nos permite etablecer la fechaCaducidad atributo de la TarjetaDeCredito, que se asociará con un usuario.
     * @param fechaCaducidad
     */
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "TarjetaDeCredito{" + "nombreTitular=" + nombreTitular + ", numeroTarjetaCredito=" + numeroTarjetaCredito + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
    
    
}
