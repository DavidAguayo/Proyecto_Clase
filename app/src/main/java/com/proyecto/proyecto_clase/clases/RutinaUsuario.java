package com.proyecto.proyecto_clase.clases;

/**
 * Created by Jorge on 29/05/2017.
 */

public class RutinaUsuario {
    private Integer id;
    private Rutina rutina;
    private Usuario usuario;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Rutina getRutina() {
        return rutina;
    }
    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public RutinaUsuario() {

    }
}
