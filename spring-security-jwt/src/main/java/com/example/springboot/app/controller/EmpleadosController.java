package com.example.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Product;
import com.example.springboot.app.service.EmpleadosService;
import com.example.springboot.app.service.ProductService;

@RestController 
@RequestMapping("/empleados")
public class EmpleadosController {

	//Inyección de dependencias
	@Autowired
	private EmpleadosService empleadosService;

	@GetMapping("/listempleados")
	public ResponseEntity<?> getAllEmpleados() {
		List<Empleados> lista = empleadosService.getAllEmpleados();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin empleados en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(empleadosService.getAllEmpleados());
	}

	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleados> getEmpleadosById(@PathVariable long id) {
		return ResponseEntity.ok().body(empleadosService.getEmpleadosById(id));
	}
	
	@PreAuthorize("hasRole('ADMIN')")//Expresion que indica que significa que solo se permitirá el acceso a los usuarios con el rol ROLE_ADMIN
	@PostMapping("/creaempleado")
	public ResponseEntity<Empleados> createEmpleados(@RequestBody Empleados product) {
		return ResponseEntity.ok().body(this.empleadosService.createProduct(product));
	}
	
	@PutMapping("/actualizaempleado/{id}")
	public ResponseEntity<Empleados> updateProduct(@PathVariable long id, @RequestBody Empleados empleados) {
		empleados.setId(id);
		return ResponseEntity.ok().body(this.empleadosService.updateEmpleados(empleados));
	}

	@DeleteMapping("/eliminaempleado/{id}")
	public HttpStatus deleteEmpleados(@PathVariable long id) {
		this.empleadosService.deleteEmpleados(id);
		return HttpStatus.OK;
	}
}