package com.benitoJuarez.escolar.model.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonalBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int idPersonal;
	
	@Size(max = 100)
	@NotNull
	private String nombrePersonal;
	
	@NotNull
	private String fechaNacimientoPersonal;
	
	@Size(max = 20)
	@NotNull
	private String sexoPersonal;
	
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
		return nombrePersonal;
	}

	public void setNombrePersonal(String nombrePersonal) {
		this.nombrePersonal = nombrePersonal;
	}

	public String getFechaNacimientoPersonal() {
		return fechaNacimientoPersonal;
	}

	public void setFechaNacimientoPersonal(String fechaNacimientoPersonal) {
		this.fechaNacimientoPersonal = fechaNacimientoPersonal;
	}

	public String getSexoPersonal() {
		return sexoPersonal;
	}

	public void setSexoPersonal(String sexoPersonal) {
		this.sexoPersonal = sexoPersonal;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	
	

}