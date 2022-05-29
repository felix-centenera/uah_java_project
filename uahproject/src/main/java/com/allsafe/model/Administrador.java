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

    /**
     *
     * @param clave password que usará el administrador.
     * @param correo Identificativo del usuario administrador.
     * @param token Se autogenerán y se establecén en tiempo de ejecución.
     */
    public Administrador(String clave, String correo, Token token) {
        super(clave, correo, token);
        this.setAdministrador(true);
    }
       
}
