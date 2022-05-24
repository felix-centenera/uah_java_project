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
public class Token {
    
    private String token;
    private LocalDateTime fechaExpiracion;//atributo que mira cuando caduca nuestro token
    /**
     * @param token
     * @param fechaExpiracion 
     * Contructor de la clase token
     */
    public Token(String token, LocalDateTime fechaExpiracion ) {
        this.token = token;
        this.fechaExpiracion = fechaExpiracion;
    }
    /**
     * @return token
     * Getter*/
    public String getToken() {
        return token;
    }
    /**
     * @param token 
     * Setter*/
    public void setToken(String token) {
        this.token = token;
    }
    /**
     * @return 
     * Getter*/
    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }
    /**
     * @param fechaExpiracion 
     * Setter
     */
    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    
   
}
