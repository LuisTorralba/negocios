package com.example.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.app.model.Airport;


public interface AirportRepository extends JpaRepository<Airport, Long> {
	// Con @Repository le indico los metodos principales select, create, update, delete
}