package com.benitoJuarez.escolar.model.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonalBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private int idPersonal;
	
	@Size(max = 100)
	@NotNull
	private String NombrePersonal;
	
	@NotNull
	private String FechaNacimientoPersonal;
	
	@Size(max = 20)
	@NotNull
	private String SexoPersonal;
	
	@NotNull
	private int idDepartamento;

	public PersonalBean() {
		super();
	}

	public PersonalBean(@NotNull int idPersonal) {
		super();
		this.idPersonal = idPersonal;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getNombrePersonal() {
		return NombrePersonal;
	}

	public void setNombrePersonal(String nombrePersonal) {
		NombrePersonal = nombrePersonal;
	}

	public String getFechaNacimientoPersonal() {
		return FechaNacimientoPersonal;
	}

	public void setFechaNacimientoPersonal(String fechaNacimientoPersonal) {
		FechaNacimientoPersonal = fechaNacimientoPersonal;
	}

	public String getSexoPersonal() {
		return SexoPersonal;
	}

	public void setSexoPersonal(String sexoPersonal) {
		SexoPersonal = sexoPersonal;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	
	

}