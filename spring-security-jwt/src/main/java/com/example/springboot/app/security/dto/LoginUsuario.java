package com.example.springboot.app.security.dto;

import javax.validation.constraints.NotBlank;

//Clase para guarar los datos del usuario que se ingresan en el login
public class LoginUsuario {

    @NotBlank //No admite un dato vacio
    private String nombreUsuario;
    @NotBlank
    private String password;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}