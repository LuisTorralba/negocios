package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Empleados;


public interface EmpleadosService {

	Empleados createEmpleados(Empleados empleados);

	Empleados updateEmpleados(Empleados empleados);
	
	List<Empleados> getAllEmpleados(); 

	Empleados getEmpleadosById(long EmpleadosId); 

	void deleteProduct(long id);
}
