package com.example.springboot.app.security.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    
    @Id//Id de la tabla, llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Id Auto Incrementable
    private int idUsuario;//El camelCase el la base de datos lo transformara a un "_" para ver la separacion de los nombres
    //Por lo que quedaria como "id_usuario"
    //Decorador para indicar que no puede ser null el campo
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)//Estos campos no se debe repetir
    private String nombreUsuario;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;

    @NotNull
    
    @ManyToMany
    
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    //Constuctor sin Id ni Roles
    public Usuario(@NotNull String nombre, 
                   @NotNull String nombreUsuario, 
                   @NotNull String email, 
                   @NotNull String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return nombreUsuario;
    }

    public void setUsuario(String usuario) {
        this.nombreUsuario = usuario;
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
