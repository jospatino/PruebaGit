package com.benitoJuarez.escolar.model.bean;

import java.io.Serializable;
import java.util.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonalDepto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idDepartamento;
	
	@Size(max = 60)
	@NotNull
	private String NombreDepto;
	
	List<String> nombre = new ArrayList<>();
	
	public PersonalDepto() {
		super();
	}



	public PersonalDepto(int idDepartamento) {
		super();
		this.idDepartamento = idDepartamento;
	}



	public int getIdDepartamento() {
		return idDepartamento;
	}



	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}



	public String getNombreDepto() {
		return NombreDepto;
	}



	public void setNombreDepto(String nombreDepto) {
		NombreDepto = nombreDepto;
	}



	public List<String> getNombre() {
		return nombre;
	}



	public void setNombre(List<String> nombre) {
		this.nombre = nombre;
	}
	
	
}
