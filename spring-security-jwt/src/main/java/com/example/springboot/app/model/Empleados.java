package com.example.springboot.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity//Notación que indica que es una entidad y permite que JPA tome esta clase de Java y pueda interpetara como una tabla en SQL
@Table(name = "employee")//Indica el nombre de la tabla, que JPA creara en la Base de Datos
public class Empleados {

    @Id //Llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.AUTO) //Se le indica que el campo ID es Autonumerico
    private long id;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    
    
    
}
 