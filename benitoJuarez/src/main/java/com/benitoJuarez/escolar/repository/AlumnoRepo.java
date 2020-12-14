package com.benitoJuarez.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benitoJuarez.escolar.model.Alumno;

public interface AlumnoRepo extends JpaRepository<Alumno, Integer> {

}

