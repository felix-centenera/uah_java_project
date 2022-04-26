/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author Rauld
 */
public class ServicesGenerateToken {
    public static String generateToken(){
        String token = "";
        char charac = 1;
        Random rand = new Random();
        
        for(int i = 0; i < 60; i++){
            
            token += ("" + ((char) rand.nextInt(32,126)));
            
        
        }
        return(token);
    }
    public static LocalDateTime generatefechaEspiracion(){
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime horaLimite = hoy.plusMinutes(4);
        return(horaLimite);
    }
   
    
    
    
}
