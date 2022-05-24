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

    public Token(String token, LocalDateTime fechaExpiracion ) {
        this.token = token;
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    
   
}
