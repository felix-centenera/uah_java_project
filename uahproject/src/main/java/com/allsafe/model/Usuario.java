/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;

import com.allsafe.service.RadomGenerator;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author felixcentenera
 */
public abstract class  Usuario implements Serializable{
    
    private String clave;
    private String correo;
    private final String idUser;
    private static int generatorId = 0;
    private Token token ;
    private boolean administrador = false;

    /**
     * Nos devuelve si el usuario es administrador o no.
     * @return
     * <ul>
     * <li> True  : Si el usuario es administrador.</li>
     * <li> False : Si el usuario no es administrador.</li>
     * </ul>
     */
    public boolean isAdministrador() {
        return administrador;
    }

    /**
     * Nos permite etablecer al usuario como administrador o establecerlo como no administrador
     * dependiendo del parametro boolean recibido.
     * @param administrador
     */
    public void setAdministrador(boolean administrador) {
            this.administrador = administrador;
    }

    /**
     * Nos permite etablecer la clave, el correo y token de un usuario.
     * @param clave
     * @param correo
     * @param token
     */
    public Usuario(String clave, String correo, Token token) {
        this.clave = clave;
        this.correo = correo;
        this.idUser = generatorId + "-"+ RadomGenerator.generateRandomPassword(10) ;
        incrementaId();
        this.token = token;
    } 
    
    /**
     * Permite incremendar un ID que se asocia al usuario.
     */
    private int incrementaId() {
        generatorId++;
        return generatorId;
    }
    
    /**
     * Nos devuelve el generatorId  atributo del usuario.
     * @return
     */
    public static int getGeneratorId() {
        return generatorId;
    }

    /**
     * Nos devuelve el idUser  atributo del usuario.
     * @return
     * <ul>
     * <li> String idUser: idUser atributo del usuario.</li>
     * </ul>
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * Nos devuelve el correo  atributo del usuario.
     * @return
     * <ul>
     * <li> String correo: correo atributo del usuario.</li>
     * </ul>
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Nos permite etablecer el correo  atributo del usuario.
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Nos devuelve la clave atributo del usuario.
     * @return
     * <ul>
     * <li> String clave: clave atributo del usuario.</li>
     * </ul>
     */
    public String getClave() {
        return clave;
    }

    /**
     * Nos permite etablecer la clave  atributo del usuario.
     * @param clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    /**
     * Nos devuelve el token atributo asociado al usuario.
     * @return
     * <ul>
     * <li> Token token: token atributo del usuario.</li>
     * </ul>
     */
    public Token getToken() {
        return token;
    }

    /**
     * Nos permite etablecer el token  atributo del usuario.
     * @param token
     */
    public void setToken(Token token) {
        this.token = token;
    }
    
    
//    private int generateRandomNumber(){
//        Random rand = new Random();
//        return rand.nextInt(0, 10000);
//    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Usuario{" + "clave=" + clave + ", correo=" + correo + ", idUser=" + idUser + '}';
    }

    

    
    
}
