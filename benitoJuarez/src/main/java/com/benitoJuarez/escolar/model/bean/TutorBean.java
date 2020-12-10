package com.benitoJuarez.escolar.model.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TutorBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id_tutor;
	
	@Size(max = 100)
	@NotNull
	private String nombre;
	
	@Size(max = 10)
	@NotNull
	private String fecha_nacimiento;
	
	@Size(max = 20)
	@NotNull
	private String sexo;

	
	
	public TutorBean() {
		super();
	}

	public TutorBean(int id_tutor) {
		super();
		this.id_tutor = id_tutor;
	}

	
	
	public int getId_tutor() {
		return id_tutor;
	}

	public void setId_tutor(int id_tutor) {
		this.id_tutor = id_tutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
}