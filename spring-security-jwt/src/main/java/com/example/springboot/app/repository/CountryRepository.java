package com.example.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.app.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
	// Con @Repository le indico los metodos principales select, create, update, delete
}