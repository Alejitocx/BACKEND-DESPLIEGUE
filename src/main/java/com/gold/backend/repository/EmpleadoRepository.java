package com.gold.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gold.backend.model.Empleado;


@Repository

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
   
}


