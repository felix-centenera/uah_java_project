/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import java.util.Random;

/**
 *
 * @author felixcentenera
 */
public class RadomGenerator {
    
    /**
     * Nos devuelve un cadena de caracteres utilizada aleatoria de un número determinado por el 
     * parametro enviado.
     * @param len
     * @return
     * <ul>
     * <li> String generateRandomPassword.</li>
     * </ul>
     */
    public static String generateRandomPassword(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
}
