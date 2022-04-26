/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import java.util.Random;

/**
 *
 * @author felixcentenera
 */
public abstract class  Usuario {
    
    private String clave;
    private String correo;
    private final String idUser;
    private static int generatorId = 0;
    private Token token ;
    private boolean administrador = false;

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
            this.administrador = administrador;
    }

    

    public Usuario(String clave, String correo, Token token) {
        this.clave = clave;
        this.correo = correo;
        this.idUser = generatorId + "-"+ generateRandomNumber() ;
        incrementaId();
        this.token = token;
    } 
    
    private int incrementaId() {
        generatorId++;
        return generatorId;
    }
    
    public static int getGeneratorId() {
        return generatorId;
    }

    public String getIdUser() {
        return idUser;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    private int generateRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(0, 10000);
    }

    @Override
    public String toString() {
        return "Usuario{" + "clave=" + clave + ", correo=" + correo + ", idUser=" + idUser + '}';
    }

    

    
    
}
