/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import java.time.LocalDateTime;

/**
 *
 * @author felixcentenera
 */
public class Opinion {
    
    private int calificacion;
    
    private String comentario;
    
    private LocalDateTime fecha;
    
    private Clientes cliente;
    
    

    public Opinion(int calificacion, String comentario, Clientes cliente) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = LocalDateTime.now();
        this.cliente =cliente;
    }
    
    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
     public String getCliente() {
        return cliente.getNombre();
    }


    @Override
    public String toString() {
        return  "Opnion{" + "calificacion=" + calificacion + ", comentario=" + comentario + ", fecha=" + fecha + '}';
    }
    
}
