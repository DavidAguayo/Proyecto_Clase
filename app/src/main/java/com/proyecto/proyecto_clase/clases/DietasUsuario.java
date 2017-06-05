package com.proyecto.proyecto_clase.clases;

/**
 * Created by Jorge on 29/05/2017.
 */

public class DietasUsuario {
    private Integer id;
    private Dieta dieta;
    private Usuario usuario;

    public DietasUsuario() {

    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Dieta getDieta() {
        return dieta;
    }
    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
