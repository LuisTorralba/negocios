package com.example.springboot.app.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.app.security.entity.Rol;
import com.example.springboot.app.security.enums.RolNombre;

import java.util.Optional;
//Notación que indica que es un repositorio
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
