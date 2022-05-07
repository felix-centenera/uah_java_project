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
     

    public LocalDateTime getFechaEntradaTienda() {
        return fechaEntradaTienda;
    }
    public void setFechaEntradaTienda(LocalDateTime fechaEntradaTienda){
        this.fechaEntradaTienda = fechaEntradaTienda;
    
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getEstrella() {
        return estrellas;
    }

  
    
      public Opinion getOpiniones(int a) {
        return opiniones.get(a);
    }

    public void introducirOpinion(Opinion o){
               opiniones.add(o);
               for (int i=0; i < opiniones.size(); i++ ){
                   estrellas= estrellas + opiniones.get(i).getCalificacion();
               }
               estrellas = round(estrellas / opiniones.size());
       }

    @Override
    public String toString() {
        return "Producto{" + "titulo=" + titulo + ", caracteristicas=" + caracteristicas + ", categoria=" + categoria + ", precio=" + precio + ", fotografia=" + fotografia + ", stock=" + stock + ", fechaEntradaTienda=" + fechaEntradaTienda + ", opinion=" + opiniones + '}';
    }

    
}
