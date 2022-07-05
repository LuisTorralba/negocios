package com.example.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.app.model.Empleados;

//Notación para indicar que es un repositorio
@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
	// Con @Repository le indico los metodos principales select, create, update, delete
}