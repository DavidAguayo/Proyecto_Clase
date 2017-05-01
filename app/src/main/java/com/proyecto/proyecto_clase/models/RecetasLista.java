package com.proyecto.proyecto_clase.models;

/**
 * Created by Aguayo's family on 30/04/2017.
 */

public class RecetasLista {
    private String nombre;
    private int img;
    public RecetasLista(String nombre, int img){
        this.nombre=nombre;
        this.img=img;
    }
    public String getNombre(){return nombre;}
    public  void setNombre(String nombre){this.nombre=nombre;}

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
