package com.proyecto.proyecto_clase.clases;

/**
 * Created by Jorge on 29/05/2017.
 */

public class Comidas {
    private Integer id;
    private String name;
    private Dia dia;

    public Comidas(){
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Dia getDia() {
        return dia;
    }
    public void setDia(Dia dia) {
        this.dia = dia;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
