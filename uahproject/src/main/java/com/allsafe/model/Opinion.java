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
    
    private String cliente;
    
    
    /**
     * @param calificacion
     * @param comentario
     * @param cliente
     * 
     * Contructor de Opinion
     */
    public Opinion(int calificacion, String comentario, String cliente) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = LocalDateTime.now();
        this.cliente =cliente;
    }
    /**
     * @return 
     * Getter*/
    public LocalDateTime getFecha() {
        return fecha;
    }
    /**
     * @return 
     * Getter */
    public String getComentario() {
        return comentario;
    }
    /**
     * @param comentario 
     * Setter*/
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return 
     * Getter*/
    public int getCalificacion() {
        return calificacion;
    }
    /**
     * @param calificacion 
     * Setter*/
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    /**
     * @return 
     * Getter
     */
     public String getCliente() {
        return cliente;
    }

     /**
      * @return
      * Retorna los atributos de cada uno de los objetos
      */
    @Override
    public String toString() {
        return  "Opnion{" + "calificacion=" + calificacion + ", comentario=" + comentario + ", fecha=" + fecha + '}';
    }
    
}
