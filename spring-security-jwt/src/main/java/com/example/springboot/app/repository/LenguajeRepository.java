package com.example.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.app.model.Lenguaje;


public interface LenguajeRepository extends JpaRepository<Lenguaje, Long> {
	// Con @Repository le indico los metodos principales select, create, update, delete
}