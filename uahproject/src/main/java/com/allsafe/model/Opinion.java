/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author felixcentenera
 */
public class Opinion implements Serializable{
    
    private int calificacion;
    
    private String comentario;
    
    private LocalDateTime fecha;
    
    private String cliente;
    
    /**
     *
     * @param calificacion
     * @param comentario
     * @param cliente
     */
    public Opinion(int calificacion, String comentario, String cliente) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = LocalDateTime.now();
        this.cliente =cliente;
    }
    
    /**
     * Nos devuelve la fecha  atributo de una opinión, que se asociará con un producto.
     * @return
     * <ul>
     * <li> LocalDateTime fecha: Fecha atributo de la  opinión.</li>
     * </ul>
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Nos devuelve el comentario  atributo de una opinión, que se asociará con un producto.
     * @return
     * <ul>
     * <li> String comentario: Comentario atributo de la  opinión.</li>
     * </ul>
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Nos permite etablecer el comentario atributo de la opinión, que se asociará con un producto.
     * @param comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Nos devuelve la calificacion  atributo de una opinión, que se asociará con un producto.
     * @return
     * <ul>
     * <li> int calificacion: calificacion atributo de una opinión.</li>
     * </ul>
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Nos permite etablecer la calificacion atributo de la opinión, que se asociará con un producto.
     * @param calificacion
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    /**
     * Nos devuelve el cliente  atributo de una opinión, que se asociará con un producto.
     * @return
     * <ul>
     * <li> String cliente: cliente atributo de una opinión.</li>
     * </ul>
     */
    public String getCliente() {
        return cliente;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return  "Opnion{" + "calificacion=" + calificacion + ", comentario=" + comentario + ", fecha=" + fecha + '}';
    }
    
}
