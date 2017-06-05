package com.proyecto.proyecto_clase.clases;

/**
 * Created by Jorge on 29/05/2017.
 */

public class Dia {
    private Integer id;
    private String name;
    private Dieta dieta;
    public Dieta getDieta() {
        return dieta;
    }
    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
    public Dia(){
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
}
