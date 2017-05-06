package com.proyecto.proyecto_clase.models;

/**
 * Created by Aguayo's family on 30/04/2017.
 */

public class RecetasLista {
    private String nombre;
    private int img;
    private String elaborar;
    public RecetasLista(String nombre, int img, String elaborar){
        this.nombre=nombre;
        this.img=img;
        this.elaborar=elaborar;
    }
    public String getNombre(){return nombre;}
    public  void setNombre(String nombre){this.nombre=nombre;}

    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }

    public String getElaborar(){return elaborar;}
    public  void setElaborar(String elaborar){this.elaborar=elaborar;}
}
