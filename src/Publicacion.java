/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class Publicacion {
    
    protected String codigo;
    protected String autor;
    protected String titulo;
    protected int cantidad;
    protected double costo;
    protected double precio;
    protected int anio;
    
    public Publicacion(){
        codigo="";
        autor="";
        titulo="";
        cantidad=0;
        costo=0;
        precio=0;
        anio=0;
    }
    
    public Publicacion(String codigo,String autor,String titulo,int cantidad,double costo,double precio,int anio){
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.costo = costo;
        this.precio = precio;
        this.anio = anio;
    }
    
    //Get
    public String getCodigo(){
        return codigo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public double getCosto(){
        return costo;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public int getAnio(){
        return anio;
    }
    
    //Set
    public void setAnio(int anio){
        this.anio = anio;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public void setCosto(double costo){
        this.costo = costo;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
}
