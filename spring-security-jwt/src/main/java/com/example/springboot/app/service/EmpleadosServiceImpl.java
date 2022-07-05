package com.example.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Empleados;
import com.example.springboot.app.repository.EmpleadosRepository;


@Service //Notación para indicar que es un servicio
@Transactional //define que un conjunto de instrucciones que se ejecutan en bloque asegura y valida el metodo termine correctamente antes de ejecutar algun otro metodo
public class EmpleadosServiceImpl implements EmpleadosService { 

	//Inyección de dependecias (crea una instancia cuando lo requiera)
	@Autowired
	private EmpleadosRepository empleadosRepository;

	@Override
	public Empleados createEmpleados(Empleados empleados) {
		return empleadosRepository.save(empleados);
	}

	@Override
	public Empleados updateEmpleados(Empleados empleados) {
		Optional<Empleados> empleadosDb = this.empleadosRepository.findById(empleados.getId());

		if (empleadosDb.isPresent()) {
			Empleados empleadosUpdate = empleadosDb.get();
			empleadosUpdate.setId(empleados.getId());
			empleadosUpdate.setApellido(empleados.getApellido());
			empleadosUpdate.setNombre(empleados.getNombre());
			empleadosRepository.save(empleadosUpdate);
			return empleadosUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + empleados.getId());
		}
	}

	@Override
	public List<Empleados> getAllEmpleados() {
		return this.empleadosRepository.findAll();
	}

	@Override
	public Empleados getEmpleadosById(long empleadosId) {

		Optional<Empleados> empleadosDb = this.empleadosRepository.findById(empleadosId);

		if (empleadosDb.isPresent()) {
			return empleadosDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + empleadosId);
		}
	}

	@Override
	public void deleteEmpleados(long empleadosId) {
		Optional<Empleados> empleadosDb = this.productRepository.findById(empleadosId);

		if (empleadosDb.isPresent()) {
			this.empleadosRepository.delete(empleadosDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + empleadosId);
		}

	}

	@Override
	public Empleados createEmpleados(Empleados empleados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleados updateEmpleados(Empleados empleados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleados> getAllEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleados getEmpleadosById(long EmpleadosId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		
	}
}
