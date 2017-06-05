package com.proyecto.proyecto_clase.clases;

/**
 * Created by Jorge on 29/05/2017.
 */

public class Alimento {
    private Integer id;
    private String name;
    private String descripcion;
    private String tipo;

    public Alimento(){
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
