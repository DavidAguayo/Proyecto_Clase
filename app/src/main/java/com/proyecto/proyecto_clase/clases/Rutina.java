package com.proyecto.proyecto_clase.clases;

/**
 * Created by Jorge on 29/05/2017.
 */

public class Rutina {
    private Integer id;
    private String name;
    private Integer dificultad;
    private String imagen;
    public Rutina() {

    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getDificultad() {
        return dificultad;
    }
    public void setDificultad(Integer dificultad) {
        this.dificultad = dificultad;
    }
}
