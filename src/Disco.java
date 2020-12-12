/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class Disco extends Publicacion {
    
    protected String genero;
    protected double duracion;
    protected String sello;
    
    public Disco(){
        codigo="";
        autor="";
        titulo="";
        cantidad=0;
        costo=0;
        precio=0;
        anio=0;
        genero = "";
        duracion = 0;
        sello = "";
    }
    
    public Disco(String codigo,String autor,String titulo,int cantidad,double costo,double precio,int anio,String genero,double duracion,String sello){
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.costo = costo;
        this.precio = precio;
        this.anio = anio;
        this.genero = genero;
        this.duracion = duracion;
        this.sello = sello;
    }
    
    //Set
    public String getGenero(){
        return genero;
    }
    
    public double getDuracion(){
        return duracion;
    }
    
    public String getSello(){
        return sello;
    }
    
    //Get
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public void setDuracion(double duracion){
        this.duracion = duracion;
    }
    
    public void setSello(String sello){
        this.sello = sello;
    }
}
