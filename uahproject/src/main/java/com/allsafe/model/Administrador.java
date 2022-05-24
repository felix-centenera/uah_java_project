/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import java.io.Serializable;

/**
 *
 * @author felixcentenera
 */
public class Administrador extends Usuario implements Serializable{

    public Administrador(String clave, String correo, Token token) {
        super(clave, correo, token);
        this.setAdministrador(true);
    }
       
}
