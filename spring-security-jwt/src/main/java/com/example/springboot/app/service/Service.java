package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Airport;
import com.example.springboot.app.model.Country;
import com.example.springboot.app.model.Empleados;
import com.example.springboot.app.model.Lenguaje;


public interface Service {

	Empleados createEmpleados(Empleados empleados);

	Empleados updateEmpleados(Empleados empleados);
	
	List<Empleados> getAllEmpleados(); 

	Empleados getEmpleadosById(long EmpleadosId); 

	void deleteEmpleados(long id);
	
	
	Country createCountry(Country country);

	Country updateCountrys(Country country);
	
	List<Country> getAllCountry(); 

	Country getCountryById(long CountryId); 

	void deleteCountry(long id);
	
	
	Lenguaje createLenguaje(Lenguaje lenguaje);

	Lenguaje updateLenguaje(Lenguaje lenguaje);
	
	List<Lenguaje> getAllLenguaje(); 

	Empleados getLenguajeById(long LenguajeId); 

	void deleteLenguaje(long id);
	
	
	Airport createAirport(Airport airport);

	Airport updateAirport(Airport airport);
	
	List<Airport> getAllAirport(); 

	Airport getAirportById(long AirportId); 

	void deleteAirport(long id);
}
