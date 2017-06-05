package com.proyecto.proyecto_clase.clases;

/**
 * Created by Jorge on 29/05/2017.
 */

public class Usuario {
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String rol;
    private String address;
    private String fechaNacimiento;
    private String fechaAlta;
    private String fechaBaja;
    private Long Peso;
    private Long Altura;
    private boolean activo = true;
    private int age;
    public Usuario() {
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
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public String getFechaBaja() {
        return fechaBaja;
    }
    public Long getPeso() {
        return Peso;
    }
    public void setPeso(Long peso) {
        Peso = peso;
    }
    public Long getAltura() {
        return Altura;
    }
    public void setAltura(Long altura) {
        Altura = altura;
    }
    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }

}
