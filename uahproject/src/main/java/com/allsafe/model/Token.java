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
public class Token implements Serializable{
    
    private String token;
    private LocalDateTime fechaExpiracion;//atributo que mira cuando caduca nuestro token

    /**
     *
     * @param token
     * @param fechaExpiracion
     */
    public Token(String token, LocalDateTime fechaExpiracion ) {
        this.token = token;
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * Nos devuelve el token  atributo del Token, que se asociará con un usuario.
     * @return
     * <ul>
     * <li> String token: token atributo de Token.</li>
     * </ul>
     */
    public String getToken() {
        return token;
    }

    /**
     * Nos permite etablecer el token atributo de Token, que se asociará con un usuario.
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *  Nos devuelve la fechaExpiracion atributo del Token, que se asociará con un usuario.
     * @return
     * <ul>
     * <li> LocalDateTime fechaExpiracion: fechaExpiracion atributo de Token.</li>
     * </ul>
     */
    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * Nos permite etablecer la fechaExpiracion atributo de Token, que se asociará con un usuario.
     * @param fechaExpiracion
     */
    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    
   
}
