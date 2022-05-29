/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.model;
import java.io.Serializable;
import static java.lang.Math.round;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author felixcentenera
 */
public class Producto implements Serializable{
    
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
     *
     * @param titulo
     * @param caracteristicas
     * @param categoria
     * @param precio
     * @param fotografia
     * @param stock
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

// ******************************************************************************************************************** 
    /**
     * Nos devuelve la fechaEntradaTienda  atributo del producto.
     * @return
     * <ul>
     * <li> LocalDateTime fechaEntradaTienda: fechaEntradaTienda atributo del producto.</li>
     * </ul>
     */
    public LocalDateTime getFechaEntradaTienda() {
        return fechaEntradaTienda;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos devuelve el stock  atributo del producto.
     * @return
     * <ul>
     * <li> int stock: stock atributo del producto.</li>
     * </ul>
     */
    public int getStock() {
        return stock;
    }
// ******************************************************************************************************************** 
    
 // ******************************************************************************************************************** 
    /**
      * Nos permite etablecer el stock atributo de un producto.
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
// ******************************************************************************************************************** 
    

// ******************************************************************************************************************** 
    /**
     * Nos devuelve la fotografia  atributo del producto.
     * @return
     * <ul>
     * <li> String fotografia: fotografia atributo del producto.</li>
     * </ul>
     */
    public String getFotografia() {
        return fotografia;
    }
// ******************************************************************************************************************** 
    
// ******************************************************************************************************************** 
    /**
     * Nos permite etablecer la fotografia atributo de un producto.
     * @param fotografia
     */
    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }
    
// ******************************************************************************************************************** 
    /**
     * Nos devuelve el precio  atributo del producto.
     * @return
     * <ul>
     * <li> int precio: precio atributo del producto.</li>
     * </ul>
     */
    public int getPrecio() {
        return precio;
    }
// ******************************************************************************************************************** 
    
// ******************************************************************************************************************** 
    /**
     * Nos permite etablecer el precio atributo de un producto.
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
// ******************************************************************************************************************** 
    
 
// ******************************************************************************************************************** 
    /**
     * Nos devuelve la categoria  atributo del producto.
     * @return
     * <ul>
     * <li> String categoria: categoria atributo del producto.</li>
     * </ul>
     */
    public String getCategoria() {
        return categoria;
    }
// ******************************************************************************************************************** 
    
    
// ******************************************************************************************************************** 
    /**
     * Nos permite etablecer la categoria atributo de un producto.
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
// ******************************************************************************************************************** 
    
// ******************************************************************************************************************** 
    /**
     * Nos devuelve las caracteristicas  atributo del producto.
     * @return
     * <ul>
     * <li> String caracteristicas: caracteristicas atributo del producto.</li>
     * </ul>
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }
// ******************************************************************************************************************** 
    

// ******************************************************************************************************************** 
    /**
     * Nos permite etablecer las caracteristicas atributo de un producto.
     * @param caracteristicas
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
// ******************************************************************************************************************** 
    
    
// ********************************************************************************************************************     
    /**
     * Nos devuelve el titulo  atributo del producto.
     * @return
     * <ul>
     * <li> String titulo: titulo atributo del producto.</li>
     * </ul>
     */
    public String getTitulo() {
        return titulo;
    }
// ******************************************************************************************************************** 
    

// ******************************************************************************************************************** 
    /**
     * Nos permite etablecer el titulo atributo de un producto.
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
// ******************************************************************************************************************** 
    
// ******************************************************************************************************************** 
    /**
     * Nos devuelve las estrellas  atributo del producto.
     * @return
     * <ul>
     * <li> int estrellas: estrellas atributo del producto.</li>
     * </ul>
     */
    public int getEstrella() {
        return estrellas;
    }
// ******************************************************************************************************************** 
    
    
// ******************************************************************************************************************** 
    /**
     * Nos devuelve la  opinión,  atributo del producto, opinión de la posición indicada como parametro.
     * @param a
     * @return
     */
    public Opinion getOpiniones(int a) {
        return opiniones.get(a);
    }
// ********************************************************************************************************************   
  
    
// ********************************************************************************************************************   
    /**
     * Nos devuelve las opiniones  atributo del producto.
     * @return
     * <ul>
     * <li> ArrayList opinon  opiniones: opiniones atributo del producto.</li>
     * </ul>
     */
    public ArrayList<Opinion>  getArrayOpiniones() {
        return opiniones;
    }
// ******************************************************************************************************************** 
    
    
// ******************************************************************************************************************** 
    /**
     * Nos permite introducir una opinión al arrayList de opiniones del producto. Añadida la opinión,
     * que contiene una calificación se recalcula el número de estrellas, que es la media de todas
     * las calificaciones de las opiniones asociadas. Recalculadas las estrellas se establece el atributo
     * estrellas al nuevo valor.
     * @param o
     */
    public void introducirOpinion(Opinion o){
               opiniones.add(o);
               estrellas =0;
               for (int i=0; i < opiniones.size(); i++ ){
                   estrellas= estrellas + opiniones.get(i).getCalificacion();
               }
               this.estrellas = round(estrellas / opiniones.size());
       }
// ******************************************************************************************************************** 
    
    
// ******************************************************************************************************************** 
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Producto{" + "titulo=" + titulo + ", caracteristicas=" + caracteristicas + ", categoria=" + categoria + ", precio=" + precio + ", fotografia=" + fotografia + ", stock=" + stock + ", fechaEntradaTienda=" + fechaEntradaTienda + ", opinion=" + opiniones + '}';
    }
// ******************************************************************************************************************** 
    
}
