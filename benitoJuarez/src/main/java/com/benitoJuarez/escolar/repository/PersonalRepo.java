package com.benitoJuarez.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benitoJuarez.escolar.model.Personal;

@Repository
public interface PersonalRepo extends JpaRepository<Personal, Integer>{

}