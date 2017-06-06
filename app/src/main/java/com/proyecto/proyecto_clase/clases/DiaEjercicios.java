package com.proyecto.proyecto_clase.clases;

/**
 * Created by jorge.sanchez on 06/06/2017.
 */

public class DiaEjercicios {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ejercicios getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicios ejercicio) {
        this.ejercicio = ejercicio;
    }

    public DiaRutina getDiaRutina() {
        return diaRutina;
    }

    public void setDiaRutina(DiaRutina diaRutina) {
        this.diaRutina = diaRutina;
    }

    private Ejercicios ejercicio;
    private DiaRutina diaRutina;


}
