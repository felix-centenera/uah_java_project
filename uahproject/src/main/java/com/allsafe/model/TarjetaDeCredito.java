/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import java.time.LocalDate;

/**
 *
 * @author felixcentenera
 */
public class TarjetaDeCredito {
    
    private String nombreTitular;
    private long numeroTarjetaCredito;
    private LocalDate fechaCaducidad;
    
    /**
     * 
     * @param nombreTitular
     * @param numeroTarjetaCredito
     * @param fechaCaducidad
     * 
     *Contructor de la clase Tareta de Credito
     */
    public TarjetaDeCredito(String nombreTitular, long numeroTarjetaCredito, LocalDate fechaCaducidad) {
        this.nombreTitular = nombreTitular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.fechaCaducidad = fechaCaducidad;
    }
    

    /**
     * @return nombreTitular
     * Getter*/
    public String getNombreTitular() {
        return nombreTitular;
    }
    /**
     * @param nombreTitular
     * Setter
     */
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    /**
     * @return 
     * Getter*/
     public long getnumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }
    /**
     * @param numeroTarjetaCredito
     * Setter
     */
    public void setNumeronumeroTarjetaCredito(long numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }
    /**
     * @return fechaCaducidad
     * Getter
     */
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
    /**
     * @param fechaCaducidad 
     * Setter*/
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    /**
     * Metodo toString() devuelve los valores de los atributos.
     */
    @Override
    public String toString() {
        return "TarjetaDeCredito{" + "nombreTitular=" + nombreTitular + ", numeroTarjetaCredito=" + numeroTarjetaCredito + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
    
    
}
