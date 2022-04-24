/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrrobot.model;

import java.time.LocalDate;

/**
 *
 * @author felixcentenera
 */
public class TarjetaDeCredito {
    
    private String nombreTitular;
    private long numeroTarjetaCredito;
    private LocalDate fechaCaducidad;

    public TarjetaDeCredito(String nombreTitular, long numeroTarjetaCredito, LocalDate fechaCaducidad) {
        this.nombreTitular = nombreTitular;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.fechaCaducidad = fechaCaducidad;
    }
    

    
    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    
     public long getnumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    public void setNumeronumeroTarjetaCredito(long numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "TarjetaDeCredito{" + "nombreTitular=" + nombreTitular + ", numeroTarjetaCredito=" + numeroTarjetaCredito + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
    
    
}
