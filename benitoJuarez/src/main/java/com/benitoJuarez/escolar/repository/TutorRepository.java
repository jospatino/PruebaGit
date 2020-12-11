package com.benitoJuarez.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benitoJuarez.escolar.model.Tutor;


@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer>{

}
