/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;
import static java.lang.Math.round;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author felixcentenera
 */
public class Producto {
    
    private String titulo;
    
    private String caracteristicas;
    
    private String categoria;
    
    private int precio;
    
    private String fotografia;
    
    private int stock;
    
    private LocalDateTime fechaEntradaTienda;
    
    private int estrellas ;
    
    private ArrayList<Opinion> opiniones ;
    
    /**
     * @param titulo
     * @param caracteristicas
     * @param categoria
     * @param precio
     * @param fotografia
     * @param stock
     *Contructor de Producto 
     */
 
    public Producto(String titulo, String caracteristicas, String categoria, int precio, String fotografia, int stock) {
        this.titulo = titulo;
        this.caracteristicas = caracteristicas;
        this.categoria = categoria;
        this.precio = precio;
        this.fotografia = fotografia;
        this.stock = stock;
        this.fechaEntradaTienda = LocalDateTime.now();
        opiniones = new ArrayList<>();
        estrellas = 0;
    }
     
    /**
     * @return 
     * Getter*/
    public LocalDateTime getFechaEntradaTienda() {
        return fechaEntradaTienda;
    }

    /**
     * @return 
     * Getter*/
    public int getStock() {
        return stock;
    }
    /**
     * @param stock 
     * Setter*/
    public void setStock(int stock) {
        this.stock = stock;
    }

    
    /**
     * @return 
     * Getter*/
    public String getFotografia() {
        return fotografia;
    }
    /**
     * @param fotografia 
     * Setter*/
    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }
    /**
     * @return 
     * Getter */
    public int getPrecio() {
        return precio;
    }
    /**
     * @param precio 
     * Setter*/
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return 
     * Getter*/
    public String getCategoria() {
        return categoria;
    }
    /**
     * @param categoria 
     * Setter*/
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return 
     * Getter*/
    public String getCaracteristicas() {
        return caracteristicas;
    }
    /**
     * @param caracteristicas 
     * Setter*/
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    /**Getter
     * @return 
     * Getter*/
    public String getTitulo() {
        return titulo;
    }
    /**
     * @param titulo 
     * Setter*/
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * @return 
     * Getter*/
    public int getEstrella() {
        return estrellas;
    }

  
    /**
     * @param a
     * @return  
     * Getter*/
    public Opinion getOpiniones(int a) {
        return opiniones.get(a);
    }
    
    /**
     * @return Getter*/
    public ArrayList<Opinion>  getArrayOpiniones() {
        return opiniones;
    }
    /**
     * @param o
     * Introduce una opinion en opiniones y cuenta las calificaciones de nuevo.
     */
    public void introducirOpinion(Opinion o){
               opiniones.add(o);
               for (int i=0; i < opiniones.size(); i++ ){
                   estrellas= estrellas + opiniones.get(i).getCalificacion();
               }
               estrellas = round(estrellas / opiniones.size());
       }
    
    /**
     * @return 
     * Retorna el valor de cada uno de los atributos del objeto Producto.
     */

    @Override
    public String toString() {
        return "Producto{" + "titulo=" + titulo + ", caracteristicas=" + caracteristicas + ", categoria=" + categoria + ", precio=" + precio + ", fotografia=" + fotografia + ", stock=" + stock + ", fechaEntradaTienda=" + fechaEntradaTienda + ", opinion=" + opiniones + '}';
    }

    
}
